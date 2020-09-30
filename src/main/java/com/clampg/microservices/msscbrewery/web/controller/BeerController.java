package com.clampg.microservices.msscbrewery.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clampg.microservices.msscbrewery.services.BeerService;
import com.clampg.microservices.msscbrewery.web.model.BeerDto;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

	@Autowired
	private BeerService beerService;
	
	/**
	 * 
	 * @param {beerId} tells Spring that beerId is a path variable
	 * @return ResponseEntity<BeerDto> this is better than just return BeerDto
	 * because ResponseEntity gives more control and can set HttpStatus 
	 */
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping // create a new beer
	// @RequestBody tells Spring to bind the JSON values in the request to 
	// the values of BeerDto, if you don't use this annotation all values in
	// beerDto will be null, no binding will occur.
	public ResponseEntity handlePost(@Valid @RequestBody BeerDto beerDto) {
		BeerDto savedBeer = beerService.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		// Idealy we want to return the full url: http://localhost:8081/api/v1/beer/{beerId}
		// we will do this later on
		// todo: add host name to url
		headers.add("Location","/api/v1/beer/"+savedBeer.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity handleUpdate(@PathVariable UUID beerId, @Valid @RequestBody BeerDto beerDto) {	
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
