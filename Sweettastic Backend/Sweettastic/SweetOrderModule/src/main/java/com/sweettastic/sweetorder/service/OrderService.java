package com.sweettastic.sweetorder.service;

import java.util.List;

import com.sweettastic.sweetorder.exception.OrderException;
import com.sweettastic.sweetorder.model.SweetOrder;

public interface OrderService {

	public String addSweetOrder(SweetOrder order);
	
	public SweetOrder updateSweetOrder(SweetOrder order);
	
	
	public String cancelSweetOrder(Integer orderId) throws OrderException;
	
	public List<SweetOrder>  showAllOrders();
	
	public String calculateTotalCost(Integer orderId) throws OrderException;
	
}
