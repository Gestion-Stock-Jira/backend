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
	@Test
	public void testGetAllProducts() {
//	String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/products")
//					.contentType(MediaType.APPLICATION_JSON))
//			.andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
//			.getResponse()
//			.getContentAsString();
//	System.out.println(response);
		System.out.println("Test test");

	}


}
