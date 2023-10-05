package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.abstracts.ProductService;
import com.turkcell.spring.starter.business.concrets.ProductServiceImp;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")

public class ProductController {
//    List<Product> productList = new ArrayList<>();


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;


    }
    @PostMapping("/save")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product product1=productService.addProduct(product);
        return new ResponseEntity<Product>(product1, HttpStatus.CREATED);

    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductForListingDto>> getAllProduct(){
        List<ProductForListingDto> allProduct=productService.getAll();
        return new ResponseEntity<List<ProductForListingDto>>(allProduct,HttpStatus.OK);
    }

@GetMapping("/{id}")
public ResponseEntity<Product> getByProductId(@PathVariable("id") int productId){
    Product productByID=productService.getProductById(productId);
    return new ResponseEntity<Product>(productByID,HttpStatus.OK);
}
@GetMapping("getById")
public List<ProductForGetByIdDto> getById(int id){
        List<ProductForGetByIdDto> geById=productService.getListingProductId(id);
        return geById;
}
    @PostMapping("saveProduct")
    public ResponseEntity add(@RequestBody @Valid ProductForAddDto request){
     productService.add(request);
        return new ResponseEntity( HttpStatus.CREATED);
    }
   @DeleteMapping("/{deleteId}")
    public ResponseEntity<ProductDeleteForDto> deleteById(@PathVariable("deleteId") int deleteId){
       productService.deleteProductById(deleteId);//neden diğerlerinden farklı
        return new ResponseEntity<ProductDeleteForDto>(HttpStatus.ACCEPTED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable short id,@RequestBody @Valid ProductForUpdateDto productForUpdateDto){

        productService.update(id,productForUpdateDto);

        return new ResponseEntity("Ürün güncellendi", HttpStatus.CREATED);
    }

    @GetMapping("getByName")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam("name") String message) {
        List<Product> products = productService.findByProductNameContaining(message);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }
    @GetMapping("searchQuantity")
    public List<Product> search(@RequestParam("name") String name) {
        List<Product> products = productService.search(name);
        return products;
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
    @GetMapping("findProductId")
    public List<Integer> findProductId(){
        List<Integer> integers =productService.findProductId();
        return integers;
    }
    @GetMapping("topCheapest")
    public List<Product> topCheapest(@RequestParam("topNumber") Integer topNumber){
        List<Product> topCheapest=productService.topCheapest(topNumber);
        return topCheapest;
    }

    @GetMapping("pcGet")
    public List<Product> pcGet(@RequestParam("id")int id){
       List<Product>pcGet= productService.pcGet(id);
       return pcGet;
    }
    @GetMapping("minAndMax")
    public List<Product> minAndMax(){
        List<Product> minAndMax=productService.maxAndMin();
        return minAndMax;
    }
    @GetMapping("minManUnit")
    public List<Product> minManUnit(@RequestParam("MinUnit") Integer minUnit, Integer manUnit){
        List<Product> minMnaUnit=productService.minManUnit(minUnit, manUnit);
        return minMnaUnit;
    }
    @GetMapping("chaiUnit")
    public List<Product> chaiUnit(@RequestParam("unit") double unitPrice){
        List<Product> chaiUnit=productService.chaiUnit(unitPrice);
        return chaiUnit;
    }

    @GetMapping("maxUnitPrice")
    public Double maxUnitPrice(){
        Double maxUnitPrice= productService.maxUnitPrice();
        return maxUnitPrice;
    }
    @GetMapping("groupById")
    public List<Product> groupById(){
        List<Product> groupById=productService.groupById();
        return groupById;
    }
    @GetMapping("getIdd")
    public Optional<Product> getId(int id){
       Optional<Product> getId= productService.getId(id);
       return getId;
    }





//
//    @PostMapping("Product")
//    public ResponseEntity addProduct(@RequestBody Product product) {
//        //built in-Hali hazırda mevcut class
//        if (product.getProductId() <= 0) {
//            return new ResponseEntity<>("Eklenecek ürün id'si 0'dan büyük olmalıdır", HttpStatus.BAD_REQUEST);
//        }
//        productList.add(product);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Product-Name", product.getProductName());
//        return new ResponseEntity(product.getProductName() + " ürün eklendi", headers, HttpStatus.CREATED);
//


//    @GetMapping("getById")
//    public Product getProductById(@RequestParam("id") int id) {
//        Product product = productRepository.findById(id).orElseThrow();
//        return product;
//
//    }
}
