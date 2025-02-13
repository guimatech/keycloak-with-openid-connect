package io.github.guimatech.keycloak_with_openid_connect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
          .requestMatchers("/").permitAll()
          .anyRequest().authenticated()
      )
      .oauth2Login()
      .and()
      .logout(logout -> logout.logoutSuccessUrl("/"));

    return http.build();
  }
}
