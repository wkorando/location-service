package com.ibm.developer.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);
	private LocationService service;
	private LocationRepo repo;

	public LocationController(LocationService service, LocationRepo repo) {
		this.service = service;
		this.repo = repo;
	}

	@GetMapping
	public ResponseEntity<Iterable<Location>> allLocations() {
		LOGGER.debug("In allLocations");
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<Iterable<Location>> findLocationsByCity(@PathVariable(name="city") String city) {
		LOGGER.debug("In allLocations");
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/country/{country}")
	public ResponseEntity<Iterable<Location>> findLocationsByCountry(@PathVariable(name="country") String country) {
		LOGGER.debug("In allLocations");
		return ResponseEntity.ok(repo.findAll());
	}
	
	
	@PostMapping
	public ResponseEntity<Location> addNewLocation(@RequestBody Location location){
		return ResponseEntity.ok(service.saveLocation(location));
	}


	@ExceptionHandler(ServerException.class)
	public ResponseEntity<String> handleServerError(ServerException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getUserMessage());
	}

	@ExceptionHandler(ClientException.class)
	public ResponseEntity<String> handleServerError(ClientException e) {
		return ResponseEntity.badRequest().body(e.getUserMessage());
	}
}
