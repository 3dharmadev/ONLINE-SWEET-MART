package com.sweettastic.product.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorDetails> productException(ProductException pe, WebRequest req){
		
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), pe.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> anyException(Exception e, WebRequest req){
		
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerFoundException(NoHandlerFoundException nhe, WebRequest req){
		
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), nhe.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> Exception(MethodArgumentNotValidException mae){
		
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), "Validation Error", mae.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
