package com.sweettastic.category.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweettastic.category.model.Category;
import com.sweettastic.category.service.CategoryService;

@RestController
public class CategoryController {
	
	private CategoryService categoryService;
	
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategoryHandler(@RequestBody Category category){
		
		Category savedCategory = categoryService.addCategory(category);
		
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Category> updateCategoryHandler(@RequestBody Category category) {
		
		Category updatedCategory = categoryService.updateCategory(category);
		
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/")
	public ResponseEntity<String> deleteCategoryHandler(@PathVariable Integer categoryId) {
		
		String result = categoryService.deleteCategory(categoryId);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	public ResponseEntity<Category> showCategoryByIdHandler(@PathVariable Integer categoryId) {
		
		Category category = categoryService.showCategoryById(categoryId);
		
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

}
