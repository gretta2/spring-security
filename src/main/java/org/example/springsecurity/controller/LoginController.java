package org.example.springsecurity.controller;

import org.example.springsecurity.JWT.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtUtil.generateToken(username);
        } catch (AuthenticationException e) {
            return "Credentials si nyazo";
        }
    }
}
