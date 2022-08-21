package com.rewards.program.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewards.program.model.PurchaseModel;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RewardsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	
	
	@Test
	public void create_purchase() throws Exception {
		PurchaseModel purhcaseModel = new PurchaseModel();
		purhcaseModel.setAmount(300);
		purhcaseModel.setCustomerId(1);
		purhcaseModel.setId(1);
		purhcaseModel.setDateofPurchase("08-21-2022");
		
		ResultActions response = mockMvc.perform(post("/createPurchase").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(purhcaseModel)));
		
		response.andExpect(status().isOk())
        .andDo(print());
		
	}
	
	@Test
	public void create_purchase_invalid_input() throws Exception {
		
		ResultActions response = mockMvc.perform(post("/createPurchase"));
		
		response.andExpect(status().isBadRequest())
        .andDo(print());
		
	}
	
	@Test
	public void get_list_of_purchases_success() throws Exception {
		
		ResultActions response = mockMvc.perform(get("/getPurchase"));
		
		response.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.size()", is(1)));
	}
	
	@Test
	public void get_purchases_by_customer_id_success() throws Exception {
		
		ResultActions response = mockMvc.perform(get("/getPurchasesByCustomer/1"));
		
		response.andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.size()", is(1)));
	}
	
	@Test
	public void get_rewards_success() throws Exception {
		
		ResultActions response = mockMvc.perform(get("/getRewards/1"));
		
		response.andExpect(status().isOk())
        .andDo(print());
	}
	
	
}
