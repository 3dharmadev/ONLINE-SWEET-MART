package com.sweettastic.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweettastic.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
