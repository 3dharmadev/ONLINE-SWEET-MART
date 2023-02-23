package com.sweettastic.sweetorder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweettastic.product.model.Product;
import com.sweettastic.sweetorder.exception.OrderException;
import com.sweettastic.sweetorder.model.SweetOrder;
import com.sweettastic.sweetorder.repository.SweetOrderRepo;

@Service
public class OrderServiceImpl  implements OrderService{

	@Autowired
	private SweetOrderRepo orderRepo;
	
	@Override
	public String addSweetOrder(SweetOrder order) {


		SweetOrder sweetOrder=orderRepo.save(order);
		
		if(sweetOrder!=null) return "Saved successfully";
		
		else throw new OrderException("wrong sweetorder id");
	}

	@Override
	public SweetOrder updateSweetOrder(SweetOrder order) {
		// TODO Auto-generated method stub
		Optional<SweetOrder> optional=orderRepo.findById(order.getSweetOrderId());
	      if(optional.isEmpty()) throw new OrderException("this sweetorder does not exists");
		return orderRepo.save(order);
	}

	@Override
	public String cancelSweetOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
		Optional<SweetOrder> optional=orderRepo.findById(orderId);
		if(optional.isPresent()) {
			orderRepo.deleteById(orderId);
			return "Product deleted successfully";
		}
		
		else throw new OrderException("with this id no order found");
		 
	}

	@Override
	public List<SweetOrder> showAllOrders() {
		 
		return orderRepo.findAll();
	}

	@Override
	public String calculateTotalCost(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
		Optional<SweetOrder> optional=orderRepo.findById(orderId);
		
		SweetOrder order=optional.get();
		
		List<Product> products=order.getProducts();
		 Double total=0.0;


		for(int i=0;i<products.size();i++) {
			total+=products.get(i).getPrice();
		}
		 
		return "Total price of this order is "+total;
	}

}
