package com.apruebaxtreme.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class MovieDatabaseCall {
    
    @Bean 
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
