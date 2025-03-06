package com.rajabuttonstore.shop.repository;

import com.rajabuttonstore.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}