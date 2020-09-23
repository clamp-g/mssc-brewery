package com.clampg.microservices.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.clampg.microservices.msscbrewery.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j // lombok annotation which adds a logger log 
public class BeerServiceImpl implements BeerService{

	@Override
	public BeerDto getBeerById(UUID beerId) {		
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Blue Girl")
				.beerStyle("Draft")
				.build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return BeerDto.builder().id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		log.debug("Updated beer "+beerId+" with details "+beerDto.toString());
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Deleted beer with id: "+beerId);
		
	}
}
