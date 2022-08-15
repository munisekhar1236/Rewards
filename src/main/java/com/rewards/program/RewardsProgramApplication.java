package com.rewards.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RewardsProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsProgramApplication.class, args);
	}

}
