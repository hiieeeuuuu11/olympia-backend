package com.example.olympiabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OlympiaBackendApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(OlympiaBackendApplication.class, args);
	}

}
