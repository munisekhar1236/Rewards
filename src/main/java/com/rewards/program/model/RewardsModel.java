package com.rewards.program.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rewards")
@Data
@Getter
@Setter
public class RewardsModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int customerId;
	private long rewardsPoints = 0;

}
