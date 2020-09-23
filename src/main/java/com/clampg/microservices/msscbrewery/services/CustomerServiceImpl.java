package com.clampg.microservices.msscbrewery.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clampg.microservices.msscbrewery.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto findCustomerById(UUID id) {
		// TODO Auto-generated method stub
		return CustomerDto.builder().id(id)
				.name("Tom Hills")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customer) {
		return CustomerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateCustomer(UUID custId) {
		log.debug(this.getClass()+" updated customer "+custId.toString());	
	}

	@Override
	public void deleteCustomer(UUID custId) {
		log.debug(this.getClass()+" deleted customer "+custId.toString());		
	}
	
	

}
