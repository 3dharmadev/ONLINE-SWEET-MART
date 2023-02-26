package com.sweettastic.service;

import java.util.Optional;

import com.sweettastic.exceptions.CategoryException;
import com.sweettastic.models.Category;
import com.sweettastic.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


 
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Override
	public Category addCategory(Category category) throws CategoryException {
		Category savedCategory = categoryRepo.save(category);
		
		return savedCategory;
	}

	@Override
	public Category updateCategory(Category category) throws CategoryException {
		Optional<Category> opt = categoryRepo.findById(category.getCategoryid());
		
		if(opt.isPresent()) {
			Category updatedCategory = categoryRepo.save(category);
			
			return updatedCategory;
		} else {
			throw new CategoryException("Category not updated!");
		}
	}

	@Override
	public String deleteCategory(Integer categoryId) throws CategoryException {
		
		Optional<Category> opt = categoryRepo.findById(categoryId);
		
		if(opt.isPresent()) {
			categoryRepo.delete(opt.get());
			
			return "Category deleted successfully.";
		} else {
			throw new CategoryException("Category not delete!");
		}
	}

	@Override
	public Category showCategoryById(Integer categoryId) throws CategoryException {
		Optional<Category> opt = categoryRepo.findById(categoryId);
		
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new CategoryException("Category not found!");
		}
	}

}
