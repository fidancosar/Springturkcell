package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.product.ProductForGetByIdDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByProductNameContaining(String productName);

    //bizi ilgilendiren ksım entity aşağıda isimlendirme ondan yle



    @Query(value="Select p FROM Product p where p.quantityPerUnit LIKE %:quantityPerUnit%", nativeQuery = false)
    List<Product> search (String quantityPerUnit);

    @Query(value = "Select * from products where product_name LIKE %:productName%", nativeQuery = true)
    List<Product> searchNative (String productName);

    @Query(value = "Select p.productName from Product p", nativeQuery = false)
    List<String>  findProductNames ();


    @Query(value = "select * from products order by unit_price limit :topNumber ",nativeQuery = true)
    List<Product> topCheapest(Integer topNumber);


    @Query(value = "select * from products where unit_price in (select max(unit_price) from products union all select min(unit_price) from products )",nativeQuery =true)
    List<Product> maxAndMin();

    @Query(value = "select * from products where unit_price>:minUnit and unit_price<:maxUnit ", nativeQuery = true)
    List<Product> minManUnit(Integer minUnit, Integer maxUnit);

    @Query(value="Select MAX(p.unitPrice) FROM Product p ", nativeQuery = false)
    Double maxUnitPrice();

    @Query(value="Select p FROM Product p group by p.productId", nativeQuery = false)
    List<Product> groupById ();

    @Query(value = "select new " +
            "com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto(p.productId,p.productName,p.quantityPerUnit,p.unitPrice,p.unitInStock,p.unitOnOrder,p.discontinued) from Product p")
    List<ProductForListingDto> getListingProduct();


    @Query(value = "select new " +
            "com.turkcell.spring.starter.entities.dtos.product.ProductForGetByIdDto" +
            "(p.productId, p.productName, p.quantityPerUnit ,p.unitPrice, p.unitInStock, " +
            "p.unitOnOrder, p.reorderLevel) from Product p where p.productId=:productId")
    List<ProductForGetByIdDto> getListingProductId(int productId);

    Product findByProductName(String productName);



//ismi chai olup max fiyatı x olan
    //en çok sipariş edilen 5 ürünü getir


}