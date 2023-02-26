package com.sweettastic.controllers;

import java.util.List;

import com.sweettastic.models.SweetOrder;
import com.sweettastic.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sweetorder")
public class SweetOrderController {
	
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/add")
	public ResponseEntity<String>  saveSweetOrder(@RequestBody SweetOrder order){
		  
		return new ResponseEntity<>(service.addSweetOrder(order),HttpStatus.CREATED);
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer id){
		return new ResponseEntity<>(service.cancelSweetOrder(id),HttpStatus.OK);

	}
	
	
	@PutMapping("/update")
	public ResponseEntity<SweetOrder> updateSweetOrder(@RequestBody SweetOrder order){
		return new ResponseEntity<>(service.updateSweetOrder(order),HttpStatus.OK);

	}
	
	
	@GetMapping("/orders")
	public ResponseEntity<List<SweetOrder>> showAllOrders(){
		return new ResponseEntity<>(service.showAllOrders(),HttpStatus.OK);

	}
	
	@GetMapping("/price/{id}")
	public ResponseEntity<String> totalPrice(@PathVariable("id") Integer id){
		return new ResponseEntity<>(service.calculateTotalCost(id),HttpStatus.OK);
	}
	
	
	

}
