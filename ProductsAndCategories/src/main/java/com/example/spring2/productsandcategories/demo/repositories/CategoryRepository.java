package com.example.spring2.productsandcategories.demo.repositories;

import com.example.spring2.productsandcategories.demo.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category>findAll();

}
