package com.example.spring2.productsandcategories.demo.repositories;

import com.example.spring2.productsandcategories.demo.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category>findAll();

    @Query(value = "SELECT * from categories c where id Not in (SELECT category_id from associations where product_id = :product_id)",nativeQuery = true)
    List<Category> findUnCategorized(long product_id);
    // @Query(value = "SELECT * FROM categories c,products p,associations a WHERE person.id not IN ( SELECT license.person_id FROM license)",nativeQuery = true)
//   @Query(value = "SELECT person.* FROM person LEFT JOIN license ON person.id=license.person_id WHERE license.person_id IS NULL",nativeQuery = true)
  //

}
