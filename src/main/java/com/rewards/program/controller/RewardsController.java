package com.rewards.program.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.program.model.RewardsModel;
import com.rewards.program.service.RewardsService;

@RestController
public class RewardsController {
	private static final Logger logger = LogManager.getLogger(PurchaseController.class);
	@Autowired
	RewardsService rewardsService;

	@GetMapping(value = "/getRewards/{customerId}")
	public ResponseEntity<RewardsModel> getRewards(@PathVariable int customerId) {
		logger.debug("get rewards ");
		return ResponseEntity.ok(rewardsService.findByCustomerId(customerId));
	}

}
