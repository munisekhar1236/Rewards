package com.rewards.program.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rewards.program.model.PurchaseModel;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PurchaseServiceTest {
	
	@Autowired PurchaseService purchaseService;
	@Autowired RewardsService rewardsService;
	
	@Test
	public void purchase_save() {
		PurchaseModel purhcaseModel = new PurchaseModel();
		purhcaseModel.setAmount(300);
		purhcaseModel.setCustomerId(1);
		purhcaseModel.setId(1);
		purhcaseModel.setDateofPurchase("08-21-2022");
		
		PurchaseModel model = purchaseService.save(purhcaseModel);
		
		assertEquals(model.getAmount(), purhcaseModel.getAmount());
		assertEquals(model.getCustomerId(), purhcaseModel.getCustomerId());
	}
	
	@Test
	public void purchase_list_all() {
		assertEquals(1, purchaseService.getAll().size());
	}

}
