package com.example.schop.repository;

import com.example.schop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByName(String name);
    @Query("SELECT p FROM Product p WHERE p.soled = :soled")
    List<Product> getBYSold(@Param("soled") boolean soled);
    void deleteById(Long id);
}
