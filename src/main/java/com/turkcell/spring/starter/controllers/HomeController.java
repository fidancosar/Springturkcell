package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("home")
@RequiredArgsConstructor
public class HomeController {
    private final MessageSource messageSource;

    List<Product> productList = new ArrayList<>();

    @GetMapping("")
    public String get(){
        return messageSource.getMessage("hello", null,LocaleContextHolder.getLocale());
    }
}