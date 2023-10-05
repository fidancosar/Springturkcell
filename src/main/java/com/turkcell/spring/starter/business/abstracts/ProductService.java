package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.ProductForAddDto;
import com.turkcell.spring.starter.entities.dtos.ProductForGetByIdDto;
import com.turkcell.spring.starter.entities.dtos.ProductForListingDto;
import com.turkcell.spring.starter.entities.dtos.ProductForUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductForListingDto> getAll();
    Product addProduct(Product product);
    Product getProductById(int productId);
    void deleteProductById(int productId);
    List<Product> findByProductNameContaining(String productName);
    List<Product> search (String productName);
    List<Product> searchNative (String productName);
    List<String>  findProductNames ();
    List<Integer>  findProductId ();
    List<Product> topCheapest(Integer topNumber);
    List<Product> pcGet(int id);
    List<Product> maxAndMin();
    List<Product> minManUnit(Integer minUnit, Integer maxUnit);
    List<Product> chaiUnit(double unitPrice);
    Double maxUnitPrice();
    List<Product> groupById ();

    List<ProductForGetByIdDto> getListingProductId(int id);

    Product update(int id, ProductForUpdateDto productForUpdateDto);
    void add(ProductForAddDto request);

    Optional<Product> getId(int id);
    Product findByProductName(String productName);


















}
