package com.sweettastic.service;

import com.sweettastic.exceptions.ProductException;
import com.sweettastic.models.Product;

import java.util.List;



public interface ProductService {
	
	public Product addProduct(Product product) throws ProductException;
	
	public Product updateProduct(Product product) throws ProductException;
	
	public String deleteProduct(Integer productId) throws ProductException;
	
	public Product showProductById(Integer productId) throws ProductException;
	
	public List<Product> showAllProduct() throws ProductException;
	
}
