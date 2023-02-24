package com.sweettastic.Cart.Model;

import java.util.ArrayList;
import java.util.List;

import com.sweettastic.product.model.Product;
import jakarta.persistence.*;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Double grandTotal;
	@OneToMany
	//@ElementCollection
	private List<Product> listProduct=new ArrayList<>();
	private Integer productCount;
	private Double total;
	public Cart() {
		super();
	}
	public Cart(Integer cartId, Double grandTotal, List<Product> listProduct, Integer productCount, Double total) {
		super();
		this.cartId = cartId;
		this.grandTotal = grandTotal;
		this.listProduct = listProduct;
		this.productCount = productCount;
		this.total = total;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public List<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"cartId=" + cartId +
				", grandTotal=" + grandTotal +
				", listProduct=" + listProduct +
				", productCount=" + productCount +
				", total=" + total +
				'}';
	}
}
