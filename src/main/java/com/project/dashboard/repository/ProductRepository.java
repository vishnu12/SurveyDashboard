package com.project.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dashboard.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
      Product findProductByName(String name);  
}
