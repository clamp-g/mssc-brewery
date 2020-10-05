package com.clampg.microservices.msscbrewery.domain;

import java.sql.Timestamp;
import java.util.UUID;

import com.clampg.microservices.msscbrewery.web.model.v2.BeerStyleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Beer object which will be persisted
 * into the DB
 * @author user
 *
 */
public class Beer {
	private UUID id;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;
	
	private Timestamp createdDate;
	private Timestamp lastModifiedDate;
}
