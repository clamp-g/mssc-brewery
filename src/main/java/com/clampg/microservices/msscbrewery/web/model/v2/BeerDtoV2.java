package com.clampg.microservices.msscbrewery.web.model.v2;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Annie Guo
 *
 */
// The following annotations are from project Lombok to 
// simplify coding
@Data // Generate getter/setter for BeerDto
@NoArgsConstructor
@AllArgsConstructor
@Builder // Implement the builder pattern
public class BeerDtoV2 {
	private UUID id;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;
	
	private OffsetDateTime createdDate;
	private OffsetDateTime lastModifiedDate;

}
