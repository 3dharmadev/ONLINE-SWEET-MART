package com.sweettastic.product.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweettastic.product.model.Product;
import com.sweettastic.product.service.ProductService;

@RestController("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProductHandler(@Valid @RequestBody Product product){
		
		Product savedProduct = productService.addProduct(product);
		
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product product){
		
		Product updatedProduct = productService.updateProduct(product);
		
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductHandler(@PathVariable("id") Integer productId){
		
		String result = productService.deleteProduct(productId);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> showProductById(@PathVariable("id") Integer productId){
		
		Product product = productService.showProductById(productId);
		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> showAllProducts(){
		
		List<Product> products = productService.showAllProduct();
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
