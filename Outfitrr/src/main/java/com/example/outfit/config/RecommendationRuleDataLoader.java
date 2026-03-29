package com.example.outfit.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.outfit.enums.ColorCategory;
import com.example.outfit.model.RecommendationRule;
import com.example.outfit.repository.RecommendationRuleRepository;

@Configuration
public class RecommendationRuleDataLoader {

    @Bean
    CommandLineRunner loadRecommendationRules(RecommendationRuleRepository repository) {
        return args -> {

            if (repository.count() > 0) {
                System.out.println("Recommendation rules already exist. Skipping data load.");
                return;
            }

            List<RecommendationRule> rules = List.of(

                    new RecommendationRule(ColorCategory.NEUTRAL, ColorCategory.WARM, 40),
                    new RecommendationRule(ColorCategory.NEUTRAL, ColorCategory.COOL, 40),
                    new RecommendationRule(ColorCategory.NEUTRAL, ColorCategory.EARTH, 35),
                    new RecommendationRule(ColorCategory.NEUTRAL, ColorCategory.PASTEL, 30),
                    new RecommendationRule(ColorCategory.NEUTRAL, ColorCategory.DARK, 45),

                    new RecommendationRule(ColorCategory.COOL, ColorCategory.NEUTRAL, 40),
                    new RecommendationRule(ColorCategory.COOL, ColorCategory.EARTH, 35),
                    new RecommendationRule(ColorCategory.COOL, ColorCategory.DARK, 30),

                    new RecommendationRule(ColorCategory.WARM, ColorCategory.NEUTRAL, 40),
                    new RecommendationRule(ColorCategory.WARM, ColorCategory.DARK, 35),
                    new RecommendationRule(ColorCategory.WARM, ColorCategory.EARTH, 45),

                    new RecommendationRule(ColorCategory.EARTH, ColorCategory.NEUTRAL, 40),
                    new RecommendationRule(ColorCategory.EARTH, ColorCategory.COOL, 30),

                    new RecommendationRule(ColorCategory.PASTEL, ColorCategory.NEUTRAL, 35),
                    new RecommendationRule(ColorCategory.PASTEL, ColorCategory.EARTH, 30),

                    new RecommendationRule(ColorCategory.DARK, ColorCategory.NEUTRAL, 40),
                    new RecommendationRule(ColorCategory.DARK, ColorCategory.PASTEL, 30)
            );

            repository.saveAll(rules);

            System.out.println("Default recommendation rules loaded successfully!");
        };
    }
}