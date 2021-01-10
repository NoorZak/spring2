package com.example.spring2.productsandcategories.demo.services;


import com.example.spring2.productsandcategories.demo.models.Category;
import com.example.spring2.productsandcategories.demo.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category createCategory(Category l) {
        return categoryRepository.save(l);
    }



}