package com.turkcell.spring.starter.business.concrets;

import com.turkcell.spring.starter.business.abstracts.ProductService;
import com.turkcell.spring.starter.core.exception.BusinessException;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.product.ProductForAddDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForGetByIdDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForUpdateDto;
import com.turkcell.spring.starter.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final MessageSource messageSource;





    public List<ProductForListingDto> getAll() {
        return productRepository.getListingProduct();
    }

    public Product getProductById(int productId){
        return productRepository.findById(productId).get();
    }
    public void deleteProductById(int productId){
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> findByProductNameContaining(String productName) {
        return productRepository.findByProductNameContaining(productName);
    }

    @Override
    public List<Product> searchNative(String productName) {
        return productRepository.searchNative(productName);
    }



    @Override
    public List<String> findProductNames() {
        return productRepository.findProductNames();
    }


    @Override
    public List<Product> topCheapest(Integer topNumber) {
        return productRepository.topCheapest(topNumber);
    }


    @Override
    public List<Product> maxAndMin() {
        return productRepository.maxAndMin();
    }

    @Override
    public List<Product> minManUnit(Integer minUnit, Integer maxUnit) {
        return productRepository.minManUnit(minUnit, maxUnit);
    }

    @Override
    public Double maxUnitPrice() {
        return productRepository.maxUnitPrice();
    }

    @Override
    public List<Product> groupById() {
        return productRepository.groupById();
    }

    @Override
    public List<ProductForGetByIdDto> getListingProductId(int id) {

        List<ProductForGetByIdDto> getByDto=productRepository.getListingProductId(id);
        if(getByDto.isEmpty()){
            throw new EntityNotFoundException("Aranan id'ye ait bir ürün yok");
        }
        return getByDto;
    }


    @Override
    public Product update(int id, ProductForUpdateDto productForUpdateDto) {


        Product product = productRepository.findById(id).orElseThrow();
//        Product product = new Product();
//        product.setProductName(productForUpdateDto.getProductName());
//        product.setUnitPrice(productForUpdateDto.getUnitPrice());
//        product.setUnitInStock(productForUpdateDto.getUnitInStock());
//        product.setUnitOnOrder(productForUpdateDto.getUnitOnOrder());
//        product.setQuantityPerUnit(productForUpdateDto.getQuantityPerUnit());
//        product.setReorderLevel(productForUpdateDto.getReorderLevel());
//        product.setDiscontinued(0);
//        return productRepository.save(product);
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);
        Product orderFromAutoMapping = modelMapper.map(productForUpdateDto, Product.class);
        return productRepository.save(orderFromAutoMapping);
    }


    @Override
    public void add(ProductForAddDto request) {

//        Product newProduct = Product.builder()
//                .productName(request.getProductName())
//                .unitPrice(request.getUnitPrice())
//                .unitInStock(request.getUnitInStock())
//                .categories(Category.builder().categoryId(request.getCategoryId()).build())
//                .suppliers(Supplier.builder().supplierId(request.getSupplierId()).build())
//                .discontinued(0)
//                .build();
        productWithSameName(request.getProductName());
        productNameShouldNotLessThanThreeCharacters(request.getProductName());
        unitPriceShouldNotBeBiggerThan50(request.getUnitPrice());
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);
        Product orderFromAutoMapping = modelMapper.map(request, Product.class);
        productRepository.save(orderFromAutoMapping);

    }

    public void productWithSameName(String productName){
        Product  productWithSameName=productRepository.findByProductName(productName);
        if(productWithSameName!=null){
            throw new BusinessException(messageSource.getMessage("productWithSameName", new Object[]{"productName"},LocaleContextHolder.getLocale()));
        }
    }
    private void productNameShouldNotLessThanThreeCharacters(String productName){

        if(productName.length()<=3){
            throw new BusinessException(messageSource.getMessage("productNameShouldNotLessThanThreeCharacters", new Object[]{"productName"}, LocaleContextHolder.getLocale()));
        }
    }
    public void unitPriceShouldNotBeBiggerThan50(double unitPrice){
        if(unitPrice>50){
            throw new BusinessException(messageSource.getMessage("unitPriceShouldNotBeBigger50",
                    new Object[]{"UnitPrice"}, LocaleContextHolder.getLocale()));
        }
    }
}