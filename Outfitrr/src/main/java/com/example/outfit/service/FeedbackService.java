package com.example.outfit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.outfit.model.Feedback;
import com.example.outfit.model.User;
import com.example.outfit.model.User;
import com.example.outfit.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback saveFeedback(Feedback feedback) {

        boolean alreadyVoted = feedbackRepository
                .existsByUserIdAndBaseColorCategoryAndRecommendedColorAndOccasionAndSkinTone(
                        feedback.getUser().getId(),
                        feedback.getBaseColorCategory(),
                        feedback.getRecommendedColor(),
                        feedback.getOccasion(),
                        feedback.getSkinTone()
                );

        if (alreadyVoted) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "You already voted for this color"
            );
        }
        return feedbackRepository.save(feedback);
    }
    
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}