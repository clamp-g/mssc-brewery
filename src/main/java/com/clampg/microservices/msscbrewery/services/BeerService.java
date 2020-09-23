package com.clampg.microservices.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.clampg.microservices.msscbrewery.web.model.BeerDto;

public interface BeerService {

	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	void updateBeer(UUID beerId, BeerDto beerDto);

	void deleteById(UUID beerId);

}
