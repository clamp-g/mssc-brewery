package com.clampg.microservices.msscbrewery.web.controller.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clampg.microservices.msscbrewery.services.v2.BeerServiceV2;
import com.clampg.microservices.msscbrewery.web.model.v2.BeerDtoV2;

/**
 * V2 - Major change
 * @author user
 *
 */
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

	@Autowired
	private BeerServiceV2 beerService;
	
	/**
	 * 
	 * @param {beerId} tells Spring that beerId is a path variable
	 * @return ResponseEntity<BeerDtoV2> this is better than just return BeerDtoV2
	 * because ResponseEntity gives more control and can set HttpStatus 
	 */
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping // create a new beer
	// @RequestBody tells Spring to bind the JSON values in the request to 
	// the values of BeerDtoV2, if you don't use this annotation all values in
	// beerDto will be null, no binding will occur.
	public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDto) {
		BeerDtoV2 savedBeer = beerService.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		// Idealy we want to return the full url: http://localhost:8081/api/v1/beer/{beerId}
		// we will do this later on
		// todo: add host name to url
		headers.add("Location","/api/v1/beer/"+savedBeer.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity handleUpdate(@PathVariable UUID beerId, 
									   @Valid @RequestBody BeerDtoV2 beerDto) {	
		beerService.updateBeer(beerId, beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);		
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	// returns a status of NO_CONTENT (204) in the response
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.deleteById(beerId);
	}
}
