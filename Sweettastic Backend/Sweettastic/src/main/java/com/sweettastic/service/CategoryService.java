package com.sweettastic.service;


import com.sweettastic.exceptions.CategoryException;
import com.sweettastic.models.Category;

public interface CategoryService {

	public Category addCategory(Category category) throws CategoryException;
	
	public Category updateCategory(Category category) throws CategoryException;
	
	public String deleteCategory(Integer categoryId) throws CategoryException;

	public Category showCategoryById(Integer categoryId) throws CategoryException;
}
