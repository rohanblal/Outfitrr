package com.example.outfit.service;

import org.springframework.stereotype.Service;

import com.example.outfit.repository.FeedbackRepository;

@Service
public class FeedbackLearningService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackLearningService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public double getFeedbackScore(String colorName) {

        long likes = feedbackRepository.countLikes(colorName);
        long dislikes = feedbackRepository.countDislikes(colorName);

        double score = (likes * 2) - (dislikes * 2);
        
        System.out.println("------ FEEDBACK SCORE CHECK ------");
        System.out.println("Color: " + colorName);
        System.out.println("Likes: " + likes);
        System.out.println("Dislikes: " + dislikes);
        System.out.println("Score: " + score);
        System.out.println("----------------------------------");

        return score;
    }
}