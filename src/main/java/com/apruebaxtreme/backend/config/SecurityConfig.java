package com.apruebaxtreme.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterSecurity(HttpSecurity http) throws Exception{

        http
        .csrf(
            csrf->csrf.disable()
        )
        .authorizeHttpRequests(
            auth->{
                auth.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/usuario")).permitAll();
                
                auth.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll();

                auth.requestMatchers(AntPathRequestMatcher.antMatcher("/themoviedb")).hasAuthority("ADMIN");

                auth.requestMatchers(AntPathRequestMatcher.antMatcher("/peliculaalquilada")).hasAuthority("USER");
                
                auth.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/peliculacatalogo")).hasAnyAuthority("ADMIN", "USER");
                auth.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/peliculacatalogo")).hasAuthority("ADMIN");
                auth.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.DELETE, "/peliculacatalogo")).hasAuthority("ADMIN");

                auth.anyRequest().authenticated();
            }
        )
        .formLogin(
            formLogin->formLogin.permitAll()
        );

        http.headers(
            headers->headers.frameOptions(
                frameOptions->frameOptions.disable()
            )
        );

        return http.build();

    }

}
