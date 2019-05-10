package com.ibm.developer.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);
	
	@GetMapping
	public ResponseEntity<String> allLocations(){
		LOGGER.debug("In allLocations");
		return ResponseEntity.ok("Hello World");
	}
}
