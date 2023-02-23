package com.sweettastic.Cart.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Product {
      @Id
	private Integer productId;
	private String name;
	private String photoPath;
	private double price;
	private String description;
	private boolean available;
	public Product() {
		super();
	}
	public Product(Integer productId, String name, String photoPath, double price, String description,
			boolean available) {
		super();
		this.productId = productId;
		this.name = name;
		this.photoPath = photoPath;
		this.price = price;
		this.description = description;
		this.available = available;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", photoPath=" + photoPath + ", price=" + price
				+ ", description=" + description + ", available=" + available + "]";
	}
	
	
}
