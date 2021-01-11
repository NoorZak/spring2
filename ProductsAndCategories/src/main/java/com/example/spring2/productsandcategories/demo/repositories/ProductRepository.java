package com.example.spring2.productsandcategories.demo.repositories;

import com.example.spring2.productsandcategories.demo.models.Category;
import com.example.spring2.productsandcategories.demo.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAll();
    @Query(value = "SELECT * from products p where id Not in (SELECT product_id from associations where category_id = :category_id)",nativeQuery = true)
    List<Product> findUnCategorized(long category_id);

}
