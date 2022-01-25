package com.projectthree.springbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@ComponentScan
@EntityScan
public class SpringBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBankingApplication.class, args);
	}

}
