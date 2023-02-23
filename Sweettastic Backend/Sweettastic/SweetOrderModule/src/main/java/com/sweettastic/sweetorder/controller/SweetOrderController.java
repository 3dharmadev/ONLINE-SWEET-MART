package com.sweettastic.sweetorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweettastic.sweetorder.model.SweetOrder;
import com.sweettastic.sweetorder.repository.SweetOrderRepo;
import com.sweettastic.sweetorder.service.OrderService;

@RestController
@RequestMapping("/sweetorder")
public class SweetOrderController {
	
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/order")
	public ResponseEntity<String>  saveSweetOrder(@RequestBody SweetOrder order){
		  
		return new ResponseEntity<>(service.addSweetOrder(order),HttpStatus.CREATED);
	}
	

	@DeleteMapping("/order/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") Integer id){
		return new ResponseEntity<>(service.cancelSweetOrder(id),HttpStatus.OK);

	}
	
	
	@GetMapping("/update/order")
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
