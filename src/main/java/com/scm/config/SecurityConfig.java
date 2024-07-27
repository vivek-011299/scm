package com.scm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User
                .withUsername("vivek")
                .password("vivek")
                .roles("ADMIN","USER")
                .build();

        UserDetails user2 = User.withUsername("user123").password("user123").build();

        var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user,user2);
        return inMemoryUserDetailsManager;
    }
}
