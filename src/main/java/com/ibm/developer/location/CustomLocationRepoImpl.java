package com.ibm.developer.location;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomLocationRepoImpl implements CustomLocationRepo {

	private JdbcTemplate jdbcTemplate;

	protected CustomLocationRepoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Iterable<Location> searchByCountry(String location) {
		return jdbcTemplate.query("SELECT * FROM locations WHERE country = ?", new Object[] {location},
				new LocationRowMapper());
	}

	class LocationRowMapper implements RowMapper<Location> {
		@Override
		public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Location(rs.getLong("id"), rs.getString("title"), rs.getString("body"));
		}
	}
}
