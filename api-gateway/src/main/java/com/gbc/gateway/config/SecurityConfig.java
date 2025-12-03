package com.gbc.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.csrf(ServerHttpSecurity.CsrfSpec::disable);

        http.authorizeExchange(ex -> ex
                .pathMatchers("/api/resources/**").hasRole("staff")
                .pathMatchers("/api/goals/**").hasRole("student")
                .pathMatchers("/api/events/register/**").hasRole("student")
                .anyExchange().authenticated()
        );

        http.oauth2ResourceServer(oauth2 -> oauth2.jwt());
        return http.build();
    }
}
