package com.example.spring2.productsandcategories.demo.repositories;

import com.example.spring2.productsandcategories.demo.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAll();

}
