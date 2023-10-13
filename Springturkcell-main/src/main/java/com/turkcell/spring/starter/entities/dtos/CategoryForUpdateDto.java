package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryForUpdateDto {

    @NotBlank(message = "Lütfen kategori adı giriniz.")
    private String categoryName;

    @NotBlank(message = "Lütfen açıklama giriniz.")
    private String description;
}
