package com.sweettastic.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweettastic.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
