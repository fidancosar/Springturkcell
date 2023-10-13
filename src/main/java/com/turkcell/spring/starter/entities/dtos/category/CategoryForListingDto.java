package com.turkcell.spring.starter.entities.dtos.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForListingDto {
    @NotBlank(message = "{categoryNameShouldNotBeBlank}")
    @Size(min=3,max=10,  message="{categoryNameShouldBeMinimum}")
    private int categoryId;
    private String categoryName;

}