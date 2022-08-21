package com.rewards.program.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rewards.program.model.PurchaseModel;
/**
 * 
 * @author Munisekhar Rangineni
 * 
 * This is a JPA interface and it is used to save or retrieve data from Purchase table.
 *
 */
@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseModel, Integer>{
	
	public PurchaseModel save(PurchaseModel purchaseModel);
	public List<PurchaseModel> findAll();
	public List<PurchaseModel> findByCustomerId(int customerId);

}
