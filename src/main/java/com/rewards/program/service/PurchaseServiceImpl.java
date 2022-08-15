package com.rewards.program.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.program.model.PurchaseModel;
import com.rewards.program.repositories.PurchaseRepo;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired PurchaseRepo purchaseRepo;
	@Autowired RewardsService rewardsService;

	@Override
	public PurchaseModel save(PurchaseModel purchaseModel) {
		rewardsService.saveOrUpdate(purchaseModel.getCustomerId(), purchaseModel.getAmount());
		return purchaseRepo.save(purchaseModel);
	}

	@Override
	public List<PurchaseModel> getAll() {
		return purchaseRepo.findAll();
	}

	@Override
	public List<PurchaseModel> getByCustomerId(int customerId) {
		return purchaseRepo.findByCustomerId(customerId);
	}

}
