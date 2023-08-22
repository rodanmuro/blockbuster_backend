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
public class BackendApplication implements CommandLineRunner{

	@Autowired
	RestTemplate restTemplate;
	

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	public void run(String[] args){

		String url = "https://api.themoviedb.org/3/search/movie?query=rings";
		String api_key="d8a89bad4afd76e415ee96730b766d8b";
		ResponseEntity<MovieResultsDTO> movieResponse = restTemplate.exchange(url+"&api_key="+api_key, HttpMethod.GET, null, MovieResultsDTO.class);

		movieResponse.getBody().getResults().stream().forEach(movie->System.out.println(movie));
	}

	
}
