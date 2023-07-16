package com.filmplanet.WebConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://movie-app-phi-lyart.vercel.app/","http://localhost:3000","https://smarth-api-gateway.azurewebsites.net/")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
