package com.apruebaxtreme.backend;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.apruebaxtreme.backend.dto.MovieResultsDTO;


@SpringBootApplication
public class BackendApplication {

	@Autowired
	RestTemplate restTemplate;
	

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	

	
}
