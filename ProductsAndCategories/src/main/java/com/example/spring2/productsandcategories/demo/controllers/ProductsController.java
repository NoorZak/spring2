package com.example.spring2.productsandcategories.demo.controllers;

import com.example.spring2.productsandcategories.demo.models.Category;
import com.example.spring2.productsandcategories.demo.models.Product;
import com.example.spring2.productsandcategories.demo.services.CategoryService;
import com.example.spring2.productsandcategories.demo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProductsController {
    private final ProductService productService;

    private final CategoryService categoryService;

    public ProductsController(ProductService productService,CategoryService categoryService) {
        this.productService=productService;
        this.categoryService=categoryService;

    }

    @RequestMapping(value="/")
    public String get() {
        return "hi.jsp";
    }



    @RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("categories",categoryService.allCategories());
        return "newProduct.jsp";
    }



    @RequestMapping(value="/products", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "newProduct.jsp";
        } else
        {
            productService.createProduct(product);
            return "redirect:/";
        }
    }

    @RequestMapping("/products/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.allCategories());

        return "showProduct.jsp";
    }



    @RequestMapping(value="/products/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("category") Category category,@PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "showProduct.jsp";
        } else {
            Product p = productService.findProduct(id);
            productService.updateProduct(p.getId(),p.getName(),p.getDescription(),p.getPrice(),category);
            return "redirect:/showProduct.jsp";
        }
    }


}
