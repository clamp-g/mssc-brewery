package com.clampg.microservices.msscbrewery.web.mappers;

import org.mapstruct.Mapper;

import com.clampg.microservices.msscbrewery.domain.Customer;
import com.clampg.microservices.msscbrewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
	CustomerDto customerToCustomerDto(Customer customer);
	Customer customerDtoToCustomer(CustomerDto customerDto);
}
