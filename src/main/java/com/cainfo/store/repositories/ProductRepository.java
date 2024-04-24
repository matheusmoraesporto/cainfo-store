package com.cainfo.store.repositories;

import com.cainfo.store.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByNameAndGenreAndCourse(String name, String genre, String course);
}
