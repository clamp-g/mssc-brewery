package com.clampg.microservices.msscbrewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clampg.microservices.msscbrewery.services.CustomerService;
import com.clampg.microservices.msscbrewery.web.model.CustomerDto;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
	
	@GetMapping("/{custId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID custId) {
		return new ResponseEntity(custService.findCustomerById(custId), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity handlePost(@Valid @RequestBody CustomerDto customer) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer"+"/"
				+custService.saveNewCustomer(customer).getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	@PutMapping("/{custId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleUpdate(@PathVariable UUID custId, 
			@Valid @RequestBody CustomerDto customer) {
		custService.updateCustomer(custId);		
	}
	@DeleteMapping("/{custId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable UUID custId) {
		custService.deleteCustomer(custId);		
	}	
}
