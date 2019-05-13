package com.ibm.developer.location;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepo extends CrudRepository<Location, Long>, CustomLocationRepo {

	Iterable<Location> findByCity(String city);
}
