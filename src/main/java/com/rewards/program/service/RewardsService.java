package com.rewards.program.service;

import com.rewards.program.model.RewardsModel;

public interface RewardsService {

	public RewardsModel findByCustomerId(int customerId);
	public boolean saveOrUpdate(int customerId, double amount);
	
	
}
