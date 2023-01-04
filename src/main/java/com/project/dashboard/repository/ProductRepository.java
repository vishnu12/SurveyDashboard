package com.project.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dashboard.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
      Product findProductByName(String name);  
}
