package com.example.employeePayroll;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class EmployeePayrollAppApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(EmployeePayrollAppApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollAppApplication.class, args);
		log.info("Employee running");
		
	}

}
