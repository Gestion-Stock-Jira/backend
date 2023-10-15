package com.gestionStock.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionStock.demo.Model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private MockMvc mockMvc;

	Product productToCreate = new Product();
	{
		productToCreate.setId(1L);
		productToCreate.setName("Test Name Jenkins");
		productToCreate.setDescription("Test Description Jenkins");
		productToCreate.setPrice(200);
		productToCreate.setQuantity(5);
	}
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Test
	public void testGetAllProducts() throws Exception {
	String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/products")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
			.getResponse()
			.getContentAsString();
	System.out.println(response);
		System.out.println("Test test");

	}
	@Test
	public void testCreateProduct() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
						.contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(productToCreate)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	@Test
	public void testGetProductById() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/products/{id}", productToCreate.getId())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

		System.out.println(response);
	}


}
