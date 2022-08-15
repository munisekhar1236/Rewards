package com.rewards.program.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.program.model.PurchaseModel;
import com.rewards.program.service.PurchaseService;

@RestController
public class PurchaseController {
	
	@Autowired PurchaseService purchaseService;
	
	@PostMapping(value="/createPurchase")
	public ResponseEntity<PurchaseModel> createPurchase(@RequestBody PurchaseModel purchaseModel){
		
		return ResponseEntity.ok(purchaseService.save(purchaseModel));
		
	}
	
	@GetMapping(value="/getPurchase")
	public ResponseEntity<List<PurchaseModel>> getAllPurchases(){
		
		return ResponseEntity.ok(purchaseService.getAll());
	}
	
	
	@GetMapping(value="/getPurchasesByCustomer/{customerId}")
	public ResponseEntity<List<PurchaseModel>> getPurchaseByCustomerId(@PathVariable int customerId){
		return ResponseEntity.ok(purchaseService.getByCustomerId(customerId));
	}

}
