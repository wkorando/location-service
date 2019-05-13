package com.ibm.developer.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
@SequenceGenerator(name = "location_id_generator", allocationSize = 1, initialValue = 10)
public class Location {

	@Id
	@GeneratedValue(generator = "location_id_generator")
	private long id;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;

	public Location() {
	}

	public Location(String city, String country) {
		this.city = city;
		this.country = country;
	}

	protected Location(long id, String city, String country) {
		this.id = id;
		this.city = city;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

}
