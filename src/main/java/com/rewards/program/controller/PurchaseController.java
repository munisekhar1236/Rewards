package com.rewards.program.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.program.model.PurchaseModel;
import com.rewards.program.service.PurchaseService;

/**
 * 
 * @author Munisekhar Rangineni
 * 
 * Purchase controller is used to perform CRUD operations on purchase table 
 *
 */
@RestController
public class PurchaseController {
	
	private static final Logger logger = LogManager.getLogger(PurchaseController.class);
	
	@Autowired PurchaseService purchaseService;
	
	/**
	 * This method is used to record the purchases and it will return the pruchase model when it saved successfully
	 * 
	 * @param purchaseModel
	 * @return Purchase model 
	 * 
	 */
	@PostMapping(value="/createPurchase")
	public ResponseEntity<PurchaseModel> createPurchase(@RequestBody PurchaseModel purchaseModel){
		logger.debug("create purchase");
		return ResponseEntity.ok(purchaseService.save(purchaseModel));
		
	}
	
	/**
	 * This method is used to get all the purchases
	 *  
	 * @return List<PurchaseModel>
	 * 
	 */
	@GetMapping(value="/getPurchase")
	public ResponseEntity<List<PurchaseModel>> getAllPurchases(){
		logger.debug("get all purchases");
		return ResponseEntity.ok(purchaseService.getAll());
	}
	
	
	/**
	 * 
	 * This method is used to get all the purchases based on customer id
	 * 
	 * @param customerId
	 * @return List<PurchaseModel>
	 * 
	 */
	@GetMapping(value="/getPurchasesByCustomer/{customerId}")
	public ResponseEntity<List<PurchaseModel>> getPurchaseByCustomerId(@PathVariable int customerId){
		logger.debug("get purchases by customer id");
		return ResponseEntity.ok(purchaseService.getByCustomerId(customerId));
	}

}
