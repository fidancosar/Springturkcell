package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
//hatalı ve istenmeyen durumları önlemek amacı ile validsayon kullanılır.
//caegıry name 3 haneden büyük olamaz
//never trust user input

@Getter
@Setter
public class CategoryForAddDto {



    private int categoryId;

    @NotBlank(message = "Kategori adı girmek zorunludur.")
    private String categoryName;
//
    @NotBlank(message = "Açıklama alanı zorunludur.")
    private String description;
}
