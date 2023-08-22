package com.apruebaxtreme.backend;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@SpringBootApplication
public class BackendApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	
}
