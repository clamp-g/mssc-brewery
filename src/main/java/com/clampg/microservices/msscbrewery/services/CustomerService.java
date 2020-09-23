package com.clampg.microservices.msscbrewery.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.clampg.microservices.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto findCustomerById(UUID id);

	CustomerDto saveNewCustomer(CustomerDto customer);

	void updateCustomer(UUID custId);

	void deleteCustomer(UUID custId);

}
