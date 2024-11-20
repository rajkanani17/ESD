package com.rajkanani.esd_yummyapp.repo;

import com.rajkanani.esd_yummyapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN 15 AND 30 ORDER BY p.price LIMIT 2")
    List<Product> findTop2ByPriceBetweenOrderByPriceAsc();
}
