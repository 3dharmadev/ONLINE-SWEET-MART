package com.sweettastic.user.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

public class universalException {

	//to handle specific InvalidRollNumberException
	@ExceptionHandler(UserException.class)
public ResponseEntity<MyErrorDetails> myIllegalHandler(UserException ie,WebRequest req)  {
		MyErrorDetails err=new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
	
 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	

}

//to handle any other type of Exception
	//to handle generic any type of Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception ie,WebRequest req)  {
	
//MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		MyErrorDetails err=new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);

	}
	
	
	
	
	//to handle Not found exception 
	@ExceptionHandler(NoHandlerFoundException.class)
public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
		

MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));

	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
				
}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me)  {
	
		
MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
	}

}
