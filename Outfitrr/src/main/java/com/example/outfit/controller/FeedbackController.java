package com.example.outfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.outfit.model.Feedback;
import com.example.outfit.model.User;
import com.example.outfit.repository.UserRepository;
import com.example.outfit.security.JwtUtil;
import com.example.outfit.service.FeedbackService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Feedback submitFeedback(
            @RequestBody Feedback feedback,
            @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.substring(7);

        String email = jwtUtil.extractEmail(token);

        System.out.println("EMAIL FROM TOKEN: " + email);

        User user = userRepository.findByEmail(email);

        System.out.println("USER FROM DB: " + user);
        System.out.println("USER ID BEING SAVED: " + user.getId());

        feedback.setUser(user);

        return feedbackService.saveFeedback(feedback);
    }
    
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }
}