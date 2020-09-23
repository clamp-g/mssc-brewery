package com.clampg.microservices.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.clampg.microservices.msscbrewery.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 { 

	BeerDtoV2 getBeerById(UUID beerId);

	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

	void updateBeer(UUID beerId, BeerDtoV2 beerDto);

	void deleteById(UUID beerId);

}
