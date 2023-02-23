package com.sweettastic.product.service;

import java.util.List;

import com.sweettastic.product.exception.ProductException;
import com.sweettastic.product.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product) throws ProductException;
	
	public Product updateProduct(Product product) throws ProductException;
	
	public String deleteProduct(Integer productId) throws ProductException;
	
	public Product showProductById(Integer productId) throws ProductException;
	
	public List<Product> showAllProduct() throws ProductException;
	
}
