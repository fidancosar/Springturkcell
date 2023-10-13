package com.turkcell.spring.starter.entities.dtos.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//hatalı ve istenmeyen durumları önlemek amacı ile validsayon kullanılır.
//caegıry name 3 haneden büyük olamaz
//never trust user input

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForAddDto {



    @NotBlank(message = "{categoryNameShouldNotBeBlank}")
    @Size(min=3,max=10,  message="{categoryNameShouldBeMinimum}")
    private String categoryName;

    @NotBlank(message = "{descriptionShouldNotBeBlank}")
    private String description;
}