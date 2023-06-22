package com.dedalus.eqpmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dedalus.eqpmgmt")
public class EquipmentMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentMgmtApplication.class, args);
		System.out.println("Application started successfully.");
	}

}
