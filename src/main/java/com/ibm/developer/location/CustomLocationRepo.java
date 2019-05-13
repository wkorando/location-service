package com.ibm.developer.location;

public interface CustomLocationRepo {

	Iterable<Location> searchByCountry(String country);
}
