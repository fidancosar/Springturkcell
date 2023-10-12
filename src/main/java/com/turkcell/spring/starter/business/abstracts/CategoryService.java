package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForListingDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForUpdateDto;


import java.util.List;

public interface CategoryService {
  List<CategoryForListingDto> getAll();
  Category addCategory(Category category);
  Category getByCategoryId(int categoryId);
  void deleteByCategoryId(int deleteId);
  List<Category> findByCategoryNameContaining(String categoryName);
  List<Category> search (String categoryName);
  Long countCategory();
  List<Category> getById(int id);

  List<Object[]> findCategoryAndProductDetails();
  void add(CategoryForAddDto request);
  void update(CategoryForUpdateDto request);


}
