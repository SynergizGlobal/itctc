package com.synergiz.itctc.config;



import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

     // Allowed origins: local dev server + the deployed VM (same-origin
        // requests from the bundled frontend don't strictly need this, but
        // it's here for any browser-based calls made across origins, e.g.
        // testing the API from a different host/port than 8081 itself)
        configuration.setAllowedOrigins(List.of(
                "http://localhost:5173",
                "http://20.193.168.130:8081"
        ));

        // Allowed HTTP Methods
        configuration.setAllowedMethods(List.of(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "OPTIONS"
        ));

        // Allowed Headers
        configuration.setAllowedHeaders(List.of("*"));

        // Allow Authorization Header (JWT)
        configuration.setAllowCredentials(true);

        // Expose Authorization header if required
        configuration.setExposedHeaders(List.of("Authorization"));

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}