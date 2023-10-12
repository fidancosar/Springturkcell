package com.turkcell.spring.starter.business.concrets;

import com.turkcell.spring.starter.business.abstracts.CategoryService;
import com.turkcell.spring.starter.core.exception.BusinessException;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForListingDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForUpdateDto;
import com.turkcell.spring.starter.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final MessageSource messageSource;


    @Override
    public Category addCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public Category getByCategoryId(int categoryId) {
        return categoryRepository.findById(categoryId).get();
    }




    @Override
    public List<Category> findByCategoryNameContaining(String categoryName) {
        return categoryRepository.findByCategoryNameContaining(categoryName);
    }

    @Override
    public List<Category> search(String categoryName) {
        return categoryRepository.search(categoryName);
    }

    @Override
    public Long countCategory() {
        return categoryRepository.countCategory();
    }

    @Override
    public List<Category> getById(int id) {
        return categoryRepository.getById(id);
    }

    @Override
    public List<Object[]> findCategoryAndProductDetails() {
        return categoryRepository.findCategoryAndProductDetails();
    }

    @Override
    public void add(CategoryForAddDto request) {

        categoryWithSameNameShouldNotExist(request.getCategoryName());
        Category category = Category.builder().build();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());

        categoryRepository.save(category);
    }
    @Override
    public void update(CategoryForUpdateDto request) {
        Category categoryToUpdate = returnCategoryByIdIfExists(request.getId());
        categoryToUpdate.setDescription(request.getDescription());
        categoryToUpdate.setCategoryName(request.getCategoryName());

        categoryRepository.save(categoryToUpdate);
    }
    @Override
    public List<CategoryForListingDto> getAll() {
//        List<Category> categories=categoryRepository.findAll();
//        List<CategoryForListingDto> categoryForListingDtos=new ArrayList<>();
//        for(Category c: categories){
//            CategoryForListingDto dto=new CategoryForListingDto();
//            dto.setCategoryId(c.getCategoryId());
//            dto.setCategoryName(c.getCategoryName());
//            categoryForListingDtos.add(dto);
//        }
        return categoryRepository.getForListing();
    }
    @Override
    public void deleteByCategoryId(int deleteId) {

        Category categoryToDelete=returnCategoryByIdIfExists(deleteId);


        categoryRepository.delete(categoryToDelete);

    }
    private Category returnCategoryByIdIfExists(int id){
        Category categoryToDelete = categoryRepository.findById(id).orElse(null);
        if(categoryToDelete==null)
            throw new BusinessException(
                    messageSource.getMessage("categoryDoesNotExistWithGivenId", new Object[] {id}, LocaleContextHolder.getLocale()));
        return categoryToDelete;
    }


    private void categoryWithSameNameShouldNotExist(String categoryName) {
        Category categoryWithSameName = categoryRepository.findByCategoryName(categoryName);
        if (categoryWithSameName != null) {
            throw new BusinessException("Aynı kategori isminden 2 kategori bulunamaz.");
        }
    }

    public void descriptionShouldNotMoreThan2Char(String description) {
        if (description.length() < 2) {
            throw new BusinessException("Açıklama kısmı 2 harften az olamaz.");
        }
    }

    private void descriptionWithSameNameShouldNotExist(String description) {
        Category categoryWithSameName = categoryRepository.findByCategoryName(description);
        if (description != null) {
            throw new BusinessException("Aynı açıklamadan 2 tane bulunamaz.");
        }
    }
}