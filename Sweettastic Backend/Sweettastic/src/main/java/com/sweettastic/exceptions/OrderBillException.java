package com.sweettastic.exceptions;

public class OrderBillException extends RuntimeException{
	
	public OrderBillException() {
		
	}
	
	public OrderBillException(String message) {
	      super(message);	
	}

}
