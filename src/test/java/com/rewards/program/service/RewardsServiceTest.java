package com.rewards.program.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rewards.program.model.RewardsModel;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RewardsServiceTest {
	@Autowired RewardsService rewardsService;
	
	@Test
	public void save_or_update_rewards() {
		assertTrue(rewardsService.saveOrUpdate(1, 300));
	}
	
	@Test
	public void get_rewards_by_id() {
		assertNotNull(rewardsService.findByCustomerId(1));
	}
	
	@Test
	public void get_rewards() {
		RewardsModel model = rewardsService.findByCustomerId(1);
		assertEquals(model.getRewardsPoints(),1300);
	}
}
