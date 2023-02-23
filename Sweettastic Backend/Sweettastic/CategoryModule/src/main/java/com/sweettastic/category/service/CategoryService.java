package com.sweettastic.category.service;

import com.sweettastic.category.exception.CategoryException;
import com.sweettastic.category.model.Category;

public interface CategoryService {

	public Category addCategory(Category category) throws CategoryException;
	
	public Category updateCategory(Category category) throws CategoryException;
	
	public String deleteCategory(Integer categoryId) throws CategoryException;

	public Category showCategoryById(Integer categoryId) throws CategoryException;
}
