package com.example.codingTaskIntership;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.codingTaskIntership.controller.CandidateController;
@ExtendWith(SpringExtension.class)
@WebMvcTest(CandidateController.class)
public class TestInt {
	@Autowired
	private MockMvc mvc;
	
	@Test
	void findOne() throws Exception {
		RequestBuilder request=  MockMvcRequestBuilders.get("/api/candidates/4");
		MvcResult result= mvc.perform(request).andReturn();
		assertEquals("", result.getResponse().getContentAsString());
	}

}
