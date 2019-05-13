package com.ibm.developer.location;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

@SpringJUnitWebConfig
@WebMvcTest(controllers = LocationController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@AutoConfigureMockMvc
public class TestLocationController {

	@MockBean
	LocationRepo repo;
	
	@MockBean
	LocationService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void callFindAllEndpoint() throws Exception {
		// Setup
		when(repo.findAll()).thenReturn(Arrays.asList(new Location(1, "Amsterdam", "Netherlands")));

		// When
		mockMvc.perform(get("/api/v1/locations"))

				// Then
				.andDo(document("find-all-locations",
						responseFields(fieldWithPath("[].id").description("The location's id"),
								fieldWithPath("[].city").description("City location"),
								fieldWithPath("[].country").description("Country location")))); //

	}
}
