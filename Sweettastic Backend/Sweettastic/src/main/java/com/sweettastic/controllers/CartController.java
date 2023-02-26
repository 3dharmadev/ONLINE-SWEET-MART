package com.sweettastic.controllers;

import java.util.List;

import com.sweettastic.models.Cart;
import com.sweettastic.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("cart")
public class CartController {

	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public ResponseEntity<Cart> addCard(@RequestBody Cart cart)
	{
		Cart c=cartService.addCard(cart);
		
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Cart> updateCard(@RequestBody Cart cart)
	{
		Cart c=cartService.updateCard(cart);
		
		return new ResponseEntity<>(c,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<String> deleteCard(@PathVariable("cartId") Integer cartId)
	{
		String c=cartService.DeleteCart(cartId);
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
