package com.example.spring2.productsandcategories.demo.controllers;

import com.example.spring2.productsandcategories.demo.models.Category;
import com.example.spring2.productsandcategories.demo.services.ProductService;
import com.example.spring2.productsandcategories.demo.services.CategoryService;
import com.example.spring2.productsandcategories.demo.models.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CategoriesController {
    private final CategoryService categoryService;

    private final ProductService productService;

    public CategoriesController(CategoryService categoryService,ProductService productService) {
        this.categoryService=categoryService;
        this.productService=productService;

    }



    @RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category, Model model) {
        model.addAttribute("categories",categoryService.allCategories());
        return "newCategory.jsp";
    }



    @RequestMapping(value="/categories", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "newCategory.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/";
        }

    }


        @RequestMapping("/categories/{id}")
        public String show(@PathVariable("id") Long id,@ModelAttribute("association") Association association, Model model) {
            Category category = categoryService.findCategory(id);
            model.addAttribute("category", category);
            model.addAttribute("products", productService.findUnCategorized(id));

            return "showCategory.jsp";
        }



        @RequestMapping(value="/categories/{id}", method=RequestMethod.PUT)
        public String update(@Valid @ModelAttribute("association") Association association, @PathVariable("id") Long id, BindingResult result) {
            if (result.hasErrors()) {
                return "showCategory.jsp";
            } else {
                Category c = categoryService.findCategory(id);
                categoryService.updateCategory(c.getId(),c.getName(),association.getProduct());
                return "redirect:/categories/{id}";
            }
        }
    }






