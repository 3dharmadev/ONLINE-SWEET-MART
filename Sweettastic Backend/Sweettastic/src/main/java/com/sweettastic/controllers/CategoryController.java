package com.sweettastic.controllers;

import com.sweettastic.models.Category;
import com.sweettastic.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Category> addCategoryHandler(@RequestBody Category category){
		
		Category savedCategory = categoryService.addCategory(category);
		
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Category> updateCategoryHandler(@RequestBody Category category) {
		
		Category updatedCategory = categoryService.updateCategory(category);
		
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategoryHandler(@PathVariable("id") Integer id) {
		
		String result = categoryService.deleteCategory(id);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> showCategoryByIdHandler(@PathVariable("id") Integer id) {
		
		Category category = categoryService.showCategoryById(id);
		
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

}
