package com.example.spring2.productsandcategories.demo.services;

import com.example.spring2.productsandcategories.demo.models.Category;
import com.example.spring2.productsandcategories.demo.models.Product;
import com.example.spring2.productsandcategories.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    public List<Product> allProducts() {
        return productRepository.findAll();
    }


    public List<Product> findUnCategorized(long category_id){
        return  productRepository.findUnCategorized(category_id);

    }
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product createProduct(Product l) {
        return productRepository.save(l);
    }


    public Product updateProduct(Long id, String name, String desc, float price , Category category) {
        Optional <Product> update = productRepository.findById(id);
        if(update != null && update.isPresent()) {
            update.get().setName(name);
            update.get().setDescription(desc);
            update.get().setPrice(price);
            update.get().getCategories().add(category);
            productRepository.save(update.get());
            return update.get();
        }
        return null;
    }

}
