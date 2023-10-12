package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.abstracts.ProductService;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.product.*;
import com.turkcell.spring.starter.entities.dtos.product.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")

public class ProductController {
//    List<Product> productList = new ArrayList<>();


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;


    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductForListingDto>> getAllProduct() {
        List<ProductForListingDto> allProduct = productService.getAll();
        return new ResponseEntity<List<ProductForListingDto>>(allProduct, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getByProductId(@PathVariable("id") int productId) {
        Product productByID = productService.getProductById(productId);
        return new ResponseEntity<Product>(productByID, HttpStatus.OK);
    }

    @GetMapping("getByIdDto")
    public List<ProductForGetByIdDto> getById(int id) {
        List<ProductForGetByIdDto> geById = productService.getListingProductId(id);
        return geById;
    }

    @PostMapping("saveProductDto")
    public ResponseEntity add(@RequestBody @Valid ProductForAddDto request) {
        productService.add(request);
        return new ResponseEntity("Ürün eklendi", HttpStatus.CREATED);
    }

    @DeleteMapping("/{deleteId}")
    public ResponseEntity<ProductDeleteForDto> deleteById(@PathVariable("deleteId") int deleteId) {
        productService.deleteProductById(deleteId);//neden diğerlerinden farklı
        return new ResponseEntity<ProductDeleteForDto>(HttpStatus.ACCEPTED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable short id, @RequestBody @Valid ProductForUpdateDto productForUpdateDto) {

        productService.update(id, productForUpdateDto);

        return new ResponseEntity("Ürün güncellendi", HttpStatus.CREATED);
    }

    @GetMapping("getByName")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam("name") String message) {
        List<Product> products = productService.findByProductNameContaining(message);
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("searchNative")
    public List<Product> searchNative(@RequestParam("name") String name) {
        List<Product> products = productService.searchNative(name);
        return products;
    }

    @GetMapping("findProductNames")
    public List<String> searchNative() {
        List<String> products = productService.findProductNames();
        return products;
    }

    @GetMapping("topCheapest")
    public List<Product> topCheapest(@RequestParam("topNumber") Integer topNumber) {
        List<Product> topCheapest = productService.topCheapest(topNumber);
        return topCheapest;
    }

    @GetMapping("minAndMax")
    public List<Product> minAndMax() {
        List<Product> minAndMax = productService.maxAndMin();
        return minAndMax;
    }

    @GetMapping("minManUnit")
    public List<Product> minManUnit(@RequestParam("MinUnit") Integer minUnit, Integer manUnit) {
        List<Product> minMnaUnit = productService.minManUnit(minUnit, manUnit);
        return minMnaUnit;
    }

    @GetMapping("maxUnitPrice")
    public Double maxUnitPrice() {
        Double maxUnitPrice = productService.maxUnitPrice();
        return maxUnitPrice;
    }

    @GetMapping("groupById")
    public List<Product> groupById() {
        List<Product> groupById = productService.groupById();
        return groupById;
    }
}
