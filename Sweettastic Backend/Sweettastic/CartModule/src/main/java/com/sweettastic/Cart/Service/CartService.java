package com.sweettastic.Cart.Service;

import java.util.List;

import com.sweettastic.Cart.Model.Cart;

public interface CartService {

	public Cart addCard(Cart card);
	public Cart updateCard(Cart card);
	public String DeleteCart(Integer cartId);
	public List<Cart> showAllCarts();
}
