package com.clampg.microservices.msscbrewery.web.mappers;

import org.mapstruct.Mapper;

import com.clampg.microservices.msscbrewery.domain.Beer;
import com.clampg.microservices.msscbrewery.web.model.v2.BeerDtoV2;

/**
 * Mapper class which mapps between
 * Beer and BeerDto
 * @author user
 *
 */
@Mapper(uses= {DateMapper.class})
public interface BeerMapper {

	BeerDtoV2 beerToBeerDto(Beer beer);
	
	Beer beerDtoToBeer(BeerDtoV2 beerDto);
}
