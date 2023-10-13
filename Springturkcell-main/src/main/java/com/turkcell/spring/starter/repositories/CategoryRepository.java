package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByCategoryNameContaining(String categoryName);

    //bizi ilgilendiren ksım entity aşağıda isimlendirme ondan yle
    @Query(value="Select c FROM Category c where c.categoryName LIKE %:categoryName%", nativeQuery = false)
    List<Category> search (String categoryName);

    @Query(value = "Select * from category where category_name LIKE %:categoryName%", nativeQuery = true)
    List<Category> searchNative (String categoryName);

    @Query(value="Select COUNT(c.categoryId) FROM Category c ", nativeQuery = false)
    Long countCategory();

    @Query(value="select c from Category c where categoryId= :categoryId")
    List<Category> getById(int categoryId);

    @Query(value = "SELECT c, p FROM Category c INNER JOIN c.products p")
    List<Object[]> findCategoryAndProductDetails();

    @Query(value = "select new " +
            "com.turkcell.spring.starter.entities.dtos.CategoryDtos.CategoryForListingDto(c.categoryId,c.categoryName) from Category c ")
    List<CategoryForListingDto> getForListing();

    Category findByCategoryName(String a);







}
