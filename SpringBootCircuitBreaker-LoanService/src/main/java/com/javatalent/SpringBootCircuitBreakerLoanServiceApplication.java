package com.javatalent;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.javatalent.entity.Loan;
import com.javatalent.repo.LoanRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootCircuitBreakerLoanServiceApplication {
	
	@Autowired
	private LoanRepository loanRepository;	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCircuitBreakerLoanServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@PostConstruct
	public void setupData() {
		loanRepository.saveAll(Arrays.asList(
				Loan.builder().id(1).type("PERSONAL").amount(200000.0).interest(0.0).build(),
				Loan.builder().id(2).type("HOUSING").amount(6000000.0).interest(0.0).build(),
				Loan.builder().id(3).type("PERSONAL").amount(1000000.0).interest(0.0).build()));
	}
}
