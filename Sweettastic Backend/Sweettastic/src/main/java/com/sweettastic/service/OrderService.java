package com.sweettastic.service;

import com.sweettastic.exceptions.OrderException;
import com.sweettastic.models.SweetOrder;

import java.util.List;



public interface OrderService {

	public String addSweetOrder(SweetOrder order);
	
	public SweetOrder updateSweetOrder(SweetOrder order);
	
	
	public String cancelSweetOrder(Integer orderId) throws OrderException;
	
	public List<SweetOrder>  showAllOrders();
	
	public String calculateTotalCost(Integer orderId) throws OrderException;
	
}
