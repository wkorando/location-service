package com.ibm.developer.location;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*
 * A quick and easy way to do database testing if you only depend a base database container. 
 * @author William.Korando@ibm.com
 *
 */
@SpringJUnitConfig
@ContextConfiguration(classes = { LocationServiceApplication.class }, initializers = ITLocationRepo.Initializer.class)
@TestPropertySource("classpath:application.properties")
//Inherit the application.properties the application would really be using, override/add properties like JDBC URL below
//More demonstration purposes, ideally properties should be managed by environment and not packaged in application artifact
//@TestMethodOrder(OrderAnnotation.class)
public class ITLocationRepo {

	public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			TestPropertyValues.of("spring.datasource.url=jdbc:tc:postgresql:11.2://localhost/test", //
					// JDBC url must start with "jdbc:tc" followed by type of database you are
					// connecting to
					"spring.datasource.username=test", //
					"spring.datasource.password=test", //
					// username/password can be arbitrary strings
					"spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver")//
					// Must use the ContainerDatabaseDriver which starts up the Docker container, is
					// eventually replaced with database appropriate driver
					.applyTo(applicationContext);
		}
	}

	@Autowired
	private LocationRepo repo;

	@Test
//	@Order(1)
	public void testReadFromStormsTable() {
		repo.save(new Location("Amsterdam", "Netherlands"));
		repo.save(new Location("Utrecht", "Netherlands"));
		assertThat(repo.count()).isEqualTo(2);

	}
}