package com.rewards.program.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rewards.program.model.PurchaseModel;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseModel, Integer>{
	
	public PurchaseModel save(PurchaseModel purchaseModel);
	public List<PurchaseModel> findAll();
	public List<PurchaseModel> findByCustomerId(int customerId);

}
