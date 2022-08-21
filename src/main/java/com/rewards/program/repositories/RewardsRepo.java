package com.rewards.program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rewards.program.model.RewardsModel;

/**
 * 
 * @author Munisekhar Rangineni
 * 
 * This is a JPA interface and it is used to save or retrieve data from Rewards table.
 *
 */
@Repository
public interface RewardsRepo extends JpaRepository<RewardsModel, Integer>{
	
	public RewardsModel findByCustomerId(int customerId);

}
