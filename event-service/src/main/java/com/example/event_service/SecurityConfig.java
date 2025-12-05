package com.group11.event-service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // OpenAPI/Swagger endpoints protected only to ADMIN
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/swagger-resources/**").hasRole("ADMIN")
                        // actuator metrics we may want to allow prometheus to scrape without auth depending on setup.
                        .requestMatchers("/actuator/prometheus").permitAll() // optional: only if you want Prometheus open
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .csrf(csrf -> csrf.disable()); // disable CSRF for simplicity (adjust for production)
        return http.build();
    }
}
