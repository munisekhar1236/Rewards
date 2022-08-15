package com.rewards.program.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "purchases")
@Data
public class PurchaseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String dateofPurchase;
	double amount;
	int customerId;
	

}
