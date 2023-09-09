package com.apruebaxtreme.backend.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.apruebaxtreme.backend.dto.UsernamePasswordDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTLoginFilter extends OncePerRequestFilter{

    @Autowired
    AuthenticationManager authenticationManager;

    private UsernamePasswordDTO usernamePasswordDTO(HttpServletRequest request){

        try {
            byte[] inputStreamBytes = StreamUtils.copyToByteArray(request.getInputStream());
            UsernamePasswordDTO usernamePasswordDTO = 
            new ObjectMapper().readValue(inputStreamBytes, UsernamePasswordDTO.class);
            return usernamePasswordDTO;
        } catch (Exception e) {
            // TODO: handle exception
            return new UsernamePasswordDTO(null, null);
        }

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                String method = request.getMethod();
                String uri = request.getRequestURI();// /login

        
    }
    
}
