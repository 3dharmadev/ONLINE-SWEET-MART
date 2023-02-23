package com.sweettastic.Cart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweettastic.Cart.Model.Cart;
import com.sweettastic.Cart.exceptions.CartsException;
import com.sweettastic.Cart.repository.CartRepositoty;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepositoty cartRepositoty;

	@Override
	public Cart addCard(Cart card) {
		
		Cart SavedCard=cartRepositoty.save(card);
		return SavedCard;
	}

	@Override
	public Cart updateCard(Cart card) {
		Optional<Cart> opt=cartRepositoty.findById(card.getCartId());
		
		if(opt.isPresent())
		{
		return cartRepositoty.save(card);
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
