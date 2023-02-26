package com.sweettastic.service;

import java.util.List;
import java.util.Optional;

import com.sweettastic.exceptions.CartsException;
import com.sweettastic.models.Cart;
import com.sweettastic.repositories.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepositoty;

	@Override
	public Cart addCard(Cart cart) {
		
		Cart SavedCart=cartRepositoty.save(cart);
		return SavedCart;
	}

	@Override
	public Cart updateCard(Cart cart) {
		Optional<Cart> opt=cartRepositoty.findById(cart.getCartId());
		
		if(opt.isPresent())
		{
		return cartRepositoty.save(cart);
		}
		else
		{
			 throw new CartsException("Cart Doen't Exist");
		}
	}

	@Override
	public String DeleteCart(Integer userId) {
		Optional<Cart> opt=cartRepositoty.findById(userId);
		if(opt.isPresent())
		{
			cartRepositoty.deleteById(userId);
			return "User Deleted";
		}
		else
		{
			throw new CartsException("user not Exist");
		}
	}

	@Override
	public List<Cart> showAllCarts() {
		List<Cart> allList=cartRepositoty.findAll();
		return allList;
	}

	
	
	
	
	
}
