package com.sweettastic.service;

import com.sweettastic.models.Cart;

import java.util.List;


public interface CartService {

	public Cart addCard(Cart cart);
	public Cart updateCard(Cart card);
	public String DeleteCart(Integer cartId);
	public List<Cart> showAllCarts();
}
