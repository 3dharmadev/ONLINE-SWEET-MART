package com.sweettastic.service;

import java.util.List;
import java.util.Optional;

import com.sweettastic.exceptions.ProductException;
import com.sweettastic.models.Product;
import com.sweettastic.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Product addProduct(Product product) throws ProductException {
		
		Product savedProduct = productRepo.save(product);
				
		return savedProduct;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		
		Optional<Product> opt = productRepo.findById(product.getProductid());
		
		if(opt.isPresent()) {
			Product updatedProduct = productRepo.save(product);
			
			return updatedProduct;
		} else {
			throw new ProductException("Product not found!");
		}
	}

	@Override
	public String deleteProduct(Integer productId) throws ProductException {

		Optional<Product> opt = productRepo.findById(productId);
		
		if(opt.isPresent()) {
			productRepo.delete(opt.get());
			
			return "Product deleted successfully.";
		} else {
			throw new ProductException("Product not found!");
		}
	}

	@Override
	public Product showProductById(Integer productId) throws ProductException {
		
		Optional<Product> opt = productRepo.findById(productId);
		
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new ProductException("Product not found!");
		}
		
	}

	@Override
	public List<Product> showAllProduct() throws ProductException {

		List<Product> products = productRepo.findAll();
		
		if(products.isEmpty()) {
			throw new ProductException("Products not exists!");
		} else {
			return products;
		}
		
	}
	
}
