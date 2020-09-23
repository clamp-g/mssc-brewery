package com.clampg.microservices.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.clampg.microservices.msscbrewery.web.model.v2.BeerDtoV2;
import com.clampg.microservices.msscbrewery.web.model.v2.BeerStyleEnum;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j // lombok annotation which adds a logger log 
public class BeerServiceImplV2 implements BeerServiceV2{

	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {		
		return BeerDtoV2.builder().id(UUID.randomUUID())
				.beerName("Blue Girl")
				.beerStyle(BeerStyleEnum.LAGER)
				.build();
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		return BeerDtoV2.builder().id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		log.debug("Updated beer "+beerId+" with details "+beerDto.toString());
	}

	@Override
	public void deleteById(UUID beerId) {
		log.debug("Deleted beer with id: "+beerId);
		
	}
}
