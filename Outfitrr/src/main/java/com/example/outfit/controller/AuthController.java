package com.example.outfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.outfit.dto.*;
import com.example.outfit.model.User;
import com.example.outfit.security.JwtUtil;
import com.example.outfit.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {

        User user = authService.register(request);

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(
            token,
            user.getName(),
            user.getEmail()
        );
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        User user = authService.login(request);

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(
            token,
            user.getName(),
            user.getEmail()
        );
    }
}