package com.rewards.program.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.program.controller.PurchaseController;
import com.rewards.program.model.PurchaseModel;
import com.rewards.program.repositories.PurchaseRepo;

/**
 * 
 * @author Munisekhar Rangineni
 * 
 *         This class is used to execute business logic and save the purchase
 *         data in to repository
 *
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

	private static final Logger logger = LogManager.getLogger(PurchaseController.class);

	@Autowired
	PurchaseRepo purchaseRepo;
	@Autowired
	RewardsService rewardsService;

	/**
	 * @param PurchaseModel
	 * @return PurchaseModel
	 * 
	 *         THis method is used save purchase records in table
	 */
	@Override
	public PurchaseModel save(PurchaseModel purchaseModel) {
		logger.debug("Save purchase");
		rewardsService.saveOrUpdate(purchaseModel.getCustomerId(), purchaseModel.getAmount());
		return purchaseRepo.save(purchaseModel);
	}

	/**
	 * @return List<PurchaseModel
	 * 
	 *         This method is used to get all the purchases
	 */
	@Override
	public List<PurchaseModel> getAll() {
		logger.debug("get all purchases");
		return purchaseRepo.findAll();
	}

	/**
	 * @param int
	 * @return List<PurchaseModel>
	 * 
	 *         This method is used to get all the purchased based on provided
	 *         customer id
	 */
	@Override
	public List<PurchaseModel> getByCustomerId(int customerId) {
		logger.debug("get purchases by customer id");
		return purchaseRepo.findByCustomerId(customerId);
	}

}
