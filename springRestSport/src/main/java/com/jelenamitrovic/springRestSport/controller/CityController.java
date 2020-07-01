package com.jelenamitrovic.springRestSport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jelenamitrovic.springRestSport.exception.ResourceNotFoundException;
import com.jelenamitrovic.springRestSport.models.City;
import com.jelenamitrovic.springRestSport.models.Sport;
import com.jelenamitrovic.springRestSport.repositories.CityRepository;
import com.jelenamitrovic.springRestSport.repositories.SportRepository;


@RestController
@RequestMapping("/api/v3")
public class CityController {

	@Autowired

	private CityRepository cityRepository;

	// create get all cities api
	@GetMapping("/cities")
	public List<City> getAllCities() {
		return cityRepository.findAll();

	}

	// create city

	@PostMapping("/cities")
	public City createCity(@Validated @RequestBody City city) {
		return cityRepository.save(city);

	}
	// get city by id

	@GetMapping("cities/{id}")
	public ResponseEntity<City> getCityById(@PathVariable(value = "id") long cityId) throws ResourceNotFoundException {
		City city = cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("City not found for this id : " + cityId));
		return ResponseEntity.ok().body(city);

	}
	// update city

	@PutMapping("/cities/{id}")
	public ResponseEntity<City> updateCity(@PathVariable(value = "id") long cityId, @RequestBody City cityDetails)
			throws ResourceNotFoundException {
		City city = cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("City not found for this id : " + cityId));
		city.setName(cityDetails.getName());
		cityRepository.save(city);
		return ResponseEntity.ok().body(city);

	}
	// delete city by id

	@DeleteMapping("/cities/{id}")
	public ResponseEntity<?> deleteCity(@PathVariable(value = "id") long cityId) throws ResourceNotFoundException {
		cityRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("City not found for this id : " + cityId));
		cityRepository.deleteById(cityId);
		return ResponseEntity.ok().build();

	}

}
