package com.w_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.w_app")
public class WAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WAppApplication.class, args);
	}

}
