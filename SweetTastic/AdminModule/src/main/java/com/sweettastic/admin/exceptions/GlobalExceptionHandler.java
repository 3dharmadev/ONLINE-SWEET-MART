package com.sweettastic.admin.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(AdminException ie, WebRequest req)  {
		
		MyErrorDetails err= new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		
	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(MethodArgumentNotValidException ie, WebRequest req)  {
		
		MyErrorDetails err= new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		
	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	
	
	//when you try to push data which does not have proper structure
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(ConstraintViolationException ie, WebRequest req)  {
		
		MyErrorDetails err= new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		
	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myanyExphandler(Exception ie, WebRequest req)  {
		
		MyErrorDetails err= new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	
		@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
				
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
						
		}
			
	
	
	
	
}
