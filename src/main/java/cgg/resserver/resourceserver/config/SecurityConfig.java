package cgg.resserver.resourceserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {
    
    @Value("${jwtUri}")
    private String jwtUri;
    @Bean
    SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        return http
            .oauth2ResourceServer(r -> r.jwt(j -> j.jwkSetUri(jwtUri)))
            .authorizeHttpRequests(a -> a.anyRequest().authenticated())
           .build();
    }
}
