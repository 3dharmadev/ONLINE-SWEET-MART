package com.sweettastic.customer.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<ErrorDetails> noHandlerFoundException(MethodArgumentNotValidException me,WebRequest wr){
		
		ErrorDetails exp=new ErrorDetails(LocalDateTime.now(),me.getMessage(),wr.getDescription(false));
		return new ResponseEntity<>(exp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	private ResponseEntity<ErrorDetails> noHandlerFoundException(CustomerException e,WebRequest wr){
		
		ErrorDetails exp=new ErrorDetails(LocalDateTime.now(),e.getMessage(),wr.getDescription(false));
		return new ResponseEntity<>(exp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	private ResponseEntity<ErrorDetails> noHandlerFoundException(ConstraintViolationException e,WebRequest wr){
		
		ErrorDetails exp=new ErrorDetails(LocalDateTime.now(),e.getMessage(),wr.getDescription(false));
		return new ResponseEntity<>(exp,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	private ResponseEntity<ErrorDetails> noHandlerFoundException(NoHandlerFoundException e,WebRequest wr){
		
		ErrorDetails exp=new ErrorDetails(LocalDateTime.now(),e.getMessage(),wr.getDescription(false));
		return new ResponseEntity<>(exp,HttpStatus.BAD_REQUEST);
	}

}
