package com.ibm.developer.location;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

	
	private LocationRepo repo;

	public LocationService(LocationRepo repo) {
		this.repo = repo;
	}
	
	public Location saveLocation(Location location) {
		if(location.getCity().isEmpty() || location.getCountry().isEmpty()) {
			throw new ClientException("Missing Required Field!");
		}
		
		return repo.save(location);
	}
}
