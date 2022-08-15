package com.rewards.program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.program.model.RewardsModel;
import com.rewards.program.service.RewardsService;

@RestController
public class RewardsController {
	
	@Autowired RewardsService rewardsService;
	
	@GetMapping(value = "/getRewards/{customerId}")
	public ResponseEntity<RewardsModel> calculateRewards(@PathVariable int customerId) {
		return ResponseEntity.ok(rewardsService.findByCustomerId(customerId));
	}
	
	
}
