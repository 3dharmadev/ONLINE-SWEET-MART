package com.sweettastic.repositories;

import com.sweettastic.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo  extends JpaRepository<Category, Integer>{

}
