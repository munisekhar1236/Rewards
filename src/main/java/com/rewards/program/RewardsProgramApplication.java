package com.rewards.program;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Munisekhar Rangineni
 * 
 * Spring boot main class
 *
 */
@SpringBootApplication
@EnableJpaRepositories
public class RewardsProgramApplication {
	 private static final Logger logger = LogManager.getLogger(RewardsProgramApplication.class);

	/**
	 * 
	 * @param args
	 * 
	 * Spring boot main method
	 */
	public static void main(String[] args) {
		logger.info("Rewards application start");
		SpringApplication.run(RewardsProgramApplication.class, args);
	}

}
