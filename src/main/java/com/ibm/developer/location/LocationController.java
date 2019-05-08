package com.ibm.developer.location;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

	@GetMapping
	public ResponseEntity<String> allLocations(){
		return ResponseEntity.ok("Hello World");
	}
}
