package com.rewards.program.service;

import java.util.List;

import com.rewards.program.model.PurchaseModel;
/**
 * 
 * @author Munisekhar Rangineni
 *
 */
public interface PurchaseService {
	
	public PurchaseModel save(PurchaseModel purchaseModel);
	public List<PurchaseModel> getAll();
	public List<PurchaseModel> getByCustomerId(int customerId);

}
