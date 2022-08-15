package com.rewards.program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rewards.program.model.RewardsModel;

@Repository
public interface RewardsRepo extends JpaRepository<RewardsModel, Integer>{
	
	public RewardsModel findByCustomerId(int customerId);

}
