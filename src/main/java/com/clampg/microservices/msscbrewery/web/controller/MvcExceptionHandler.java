package com.clampg.microservices.msscbrewery.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice will advice the Spring MVC
// that is class will handle exception for all 
// controller classes
@ControllerAdvice
public class MvcExceptionHandler {

	/**
	 * Now we consolidate all exception handling
	 * in our controller classes in this class so
	 * the controller classes don't need to handle
	 * exceptions hence reduces a lot of duplicated
	 * code
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List> validationErrorHandler (ConstraintViolationException e) {
		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
		e.getConstraintViolations().forEach(constraintViolation -> {
			errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());		
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<List> handleBindException(BindException ex){
		return new ResponseEntity(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
	}
}
