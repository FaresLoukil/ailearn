package com.esprit.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> {
                            // Optional JWT customization if needed
                        })
                );

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        // Example for JWK Set URI from Keycloak
        return NimbusJwtDecoder.withJwkSetUri("http://localhost:8080/realms/<your-realm>/protocol/openid-connect/certs").build();
    }
}

