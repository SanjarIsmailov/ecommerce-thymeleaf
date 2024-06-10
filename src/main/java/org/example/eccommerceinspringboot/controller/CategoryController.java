package org.example.eccommerceinspringboot.controller;

import lombok.RequiredArgsConstructor;
import org.example.eccommerceinspringboot.entity.Category;
import org.example.eccommerceinspringboot.repo.CategoryRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RequiredArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepo categoryRepo;
    @PostMapping
    public String savaCategory(@RequestParam String name) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        LocalDateTime localDateTime = LocalDateTime.parse(formattedDateTime, formatter);
        Category category = new Category(name, localDateTime);
        categoryRepo.save(category);
        return "redirect:/admin/category";
    }
}
