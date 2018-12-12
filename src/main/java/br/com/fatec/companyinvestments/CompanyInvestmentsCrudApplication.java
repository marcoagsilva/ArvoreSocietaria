package br.com.fatec.companyinvestments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyInvestmentsCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyInvestmentsCrudApplication.class, args);
		System.out.println("Company Service is running...");
	}
}
