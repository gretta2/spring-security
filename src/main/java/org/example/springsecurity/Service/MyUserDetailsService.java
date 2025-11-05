package org.example.springsecurity.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("gretta")
                .password("$2a$10$7Q3z3nOj1q6gKzOAx0qfie6S/g2HDpYjPwHlWhkFmb1NciN7G1G1i")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("$2a$10$7Q3z3nOj1q6gKzOAx0qfie6S/g2HDpYjPwHlWhkFmb1NciN7G1G1i")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
