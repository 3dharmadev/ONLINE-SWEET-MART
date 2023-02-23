package com.sweettastic.Cart.Controller;

import java.util.List;

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

import com.sweettastic.Cart.Model.Cart;
import com.sweettastic.Cart.Service.CartService;

@RestController
public class CardController {

	
	@Autowired
	private  CartService cartService;
	
	@PostMapping("/carts")
	public ResponseEntity<Cart> addCard(@RequestBody Cart card)
	{
		Cart c=cartService.addCard(card);
		
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/carts")
	public ResponseEntity<Cart> updateCard(@RequestBody Cart card)
	{
		Cart c=cartService.updateCard(card);
		
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/carts/{cartId}")
	public ResponseEntity<String> deleteCard(@PathVariable("cartId") Integer cartid)
	{
		String c=cartService.DeleteCart(cartid);
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/carts")
	public ResponseEntity<List<Cart>> allListOfCart(){
		
	       List<Cart> carts =cartService.showAllCarts();
		
		if(!carts.isEmpty())
		{
			return new ResponseEntity<>(carts,HttpStatus.OK);
		}
		else
		{
			throw new IllegalArgumentException("Carts List is Empty");
		}
	}
	
}
