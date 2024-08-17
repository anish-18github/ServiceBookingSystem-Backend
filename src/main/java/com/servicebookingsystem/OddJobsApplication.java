package com.servicebookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OddJobsApplication {

	@GetMapping("/test")
	public String index () {
		return "<h1>Hello world</h1>";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OddJobsApplication.class, args);
		
	}

}
