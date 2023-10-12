package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.abstracts.CategoryService;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForListingDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForUpdateDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("categories")

public class CategoryController {


    private final CategoryService categoryService;


    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;

    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryForListingDto>> getAll() {
        List<CategoryForListingDto> getCategory = categoryService.getAll();
        return new ResponseEntity<List<CategoryForListingDto>>(getCategory, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Category> saveAll(@RequestBody Category category) {
        Category saveAll = categoryService.addCategory(category);
        return new ResponseEntity<Category>(saveAll, HttpStatus.CREATED);
    }

    @PostMapping("saveDto")
    public ResponseEntity add(@RequestBody @Valid CategoryForAddDto request) {
        categoryService.add(request);
        return new ResponseEntity("Kategori eklendi", HttpStatus.CREATED);
    }

    @PutMapping()
    public void update(@RequestBody CategoryForUpdateDto request) {
        categoryService.update(request);
    }

    public ResponseEntity<Category> getByCategoryId(@PathVariable("id") int CategoryId) {
        Category getCategory = categoryService.getByCategoryId(CategoryId);
        return new ResponseEntity<Category>(getCategory, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategoryId(@PathVariable("id") int deleteId) {
        categoryService.deleteByCategoryId(deleteId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping("getByName")
    public List<Category> getCategoryByName(@RequestParam("name") String message) {
        List<Category> categories = categoryService.findByCategoryNameContaining(message);
        return categories;
    }

    @GetMapping("search")
    public List<Category> search(@RequestParam("name") String name) {
        List<Category> categories = categoryService.search(name);
        return categories;
    }

    @GetMapping("countCategory")
    public Long countCategory() {
        Long countCategory = categoryService.countCategory();
        return countCategory;
    }

    @GetMapping("getById/{id}")
    public List<Category> getById(@PathVariable("id") int id) {
        List<Category> getById = categoryService.getById(id);
        return getById;
    }

    @GetMapping("categoryAndProduct")
    public List<Object[]> findCategoryAndProductDetails() {
        List<Object[]> findCategoryAndProductDetails = categoryService.findCategoryAndProductDetails();
        return findCategoryAndProductDetails;
    }
}