package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.product.ProductForAddDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForGetByIdDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductForListingDto> getAll();

    Product getProductById(int productId);

    void deleteProductById(int productId);

    List<Product> findByProductNameContaining(String productName);

    List<Product> searchNative(String productName);

    List<String> findProductNames();

    List<Product> topCheapest(Integer topNumber);

    List<Product> maxAndMin();

    List<Product> minManUnit(Integer minUnit, Integer maxUnit);

    Double maxUnitPrice();

    List<Product> groupById();

    List<ProductForGetByIdDto> getListingProductId(int id);

    Product update(int id, ProductForUpdateDto productForUpdateDto);

    void add(ProductForAddDto request);


}