package com.rewards.program.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rewards.program.model.RewardsModel;
import com.rewards.program.repositories.RewardsRepo;

/**
 * 
 * @author Munisekhar Rangineni
 * 
 *         This class is used to execute business logic and save or retrieve the
 *         data from rewards repo.
 *
 */
@Service
public class RewardsServiceImpl implements RewardsService {
	private static final Logger logger = LogManager.getLogger(RewardsServiceImpl.class);
	@Autowired
	RewardsRepo rewardsRepo;

	@Value("${level1ValueAmount}")
	Integer level1ValueAmount;

	@Value("${level1ValueRewards}")
	Integer level1ValueRewards;

	@Value("${level2ValueAmount}")
	Integer level2ValueAmount;

	@Value("${level2ValueRewards}")
	Integer level2ValueRewards;

	/**
	 * @param int
	 * 
	 * @return RewardsModel
	 * 
	 *         This method is used to get rewards from rewards table based on
	 *         provided customerId
	 */
	@Override
	public RewardsModel findByCustomerId(int customerId) {
		logger.debug("find rewards by customer id");
		return rewardsRepo.findByCustomerId(customerId);
	}

	/**
	 * @param int
	 * 
	 * @param double
	 * 
	 * @return boolean
	 * 
	 *         This method is used to calculate reward points and save it in the
	 *         rewards table for provided customer id
	 */
	@Override
	public boolean saveOrUpdate(int customerId, double amount) {
		logger.debug("save or update rewards");
		RewardsModel rewardsModel = rewardsRepo.findByCustomerId(customerId);
		if (null == rewardsModel) {
			rewardsModel = new RewardsModel();

		}
		rewardsModel.setCustomerId(customerId);
		rewardsModel.setRewardsPoints(rewardsModel.getRewardsPoints() + calcualteRewards(amount));

		rewardsRepo.save(rewardsModel);

		return true;

	}

	/**
	 * This method is used to calculate reward points based on provided amount and
	 * it will return the number of reward points
	 * 
	 * @param amount
	 * @return
	 */
	private long calcualteRewards(double amount) {
		logger.debug("calculate rewards");
		/*
		 * as per business we have to round the amount and need to calculate reward
		 * points based on amount levels
		 */
		long rewards = Math.round((amount - level1ValueAmount) * level1ValueRewards);
		int quotient = (int) (amount / level2ValueAmount);
		rewards += (quotient - 1) * level2ValueAmount * level2ValueRewards;

		return rewards;
	}

}
