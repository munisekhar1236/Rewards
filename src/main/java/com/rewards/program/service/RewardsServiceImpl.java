package com.rewards.program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rewards.program.model.RewardsModel;
import com.rewards.program.repositories.RewardsRepo;

@Service
public class RewardsServiceImpl implements RewardsService{
	
	@Autowired RewardsRepo rewardsRepo;
	
	@Value("${level1ValueAmount}")
	Integer level1ValueAmount;
	
	@Value("${level1ValueRewards}")
	Integer level1ValueRewards;

	@Value("${level2ValueAmount}")
	Integer level2ValueAmount;
	
	@Value("${level2ValueRewards}")
	Integer level2ValueRewards;
	
	@Override
	public RewardsModel findByCustomerId(int customerId) {
		return rewardsRepo.findByCustomerId(customerId);
	}
	
	@Override
	public boolean saveOrUpdate(int customerId, double amount) {
		
		RewardsModel rewardsModel = rewardsRepo.findByCustomerId(customerId);
		if(null == rewardsModel) {
			 rewardsModel = new RewardsModel();
			 
		}
		rewardsModel.setCustomerId(customerId);
		rewardsModel.setRewardsPoints(rewardsModel.getRewardsPoints()+calcualteRewards(amount));
		
		rewardsRepo.save(rewardsModel);
		
		return true;
		
	}
	
	private  long calcualteRewards(double amount) {
		
		long rewards = Math.round((amount-level1ValueAmount) * level1ValueRewards);
		int quotient = (int) (amount/level2ValueAmount);
		rewards+= (quotient-1)*level2ValueAmount*level2ValueRewards;
		
		return rewards;
	}

}
