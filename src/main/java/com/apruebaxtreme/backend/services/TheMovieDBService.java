package com.apruebaxtreme.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apruebaxtreme.backend.dto.MovieResultsDTO;

@Service
public class TheMovieDBService {

    @Autowired
	RestTemplate restTemplate;

    private String END_POINT = "https://api.themoviedb.org/3/search/movie?";

    @Value("${movies.api.key}")
    private String API_KEY;

    public MovieResultsDTO movieResultsDTO(String query){
        if(query==null){
            query="";
        }

		ResponseEntity<MovieResultsDTO> movieResponse = restTemplate.exchange(END_POINT+"&api_key="+API_KEY+"&query="+query, HttpMethod.GET, null, MovieResultsDTO.class);
		return movieResponse.getBody();
    }
    
}
