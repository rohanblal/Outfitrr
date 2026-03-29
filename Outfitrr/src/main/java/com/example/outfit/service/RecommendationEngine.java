package com.example.outfit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.outfit.enums.BrightnessLevel;
import com.example.outfit.enums.ColorCategory;
import com.example.outfit.enums.Occasion;
import com.example.outfit.enums.SkinTone;
import com.example.outfit.model.RecommendationRule;
import com.example.outfit.repository.RecommendationRuleRepository;

@Service
public class RecommendationEngine {

	private final RecommendationRuleRepository ruleRepository;

	public List<RecommendationResult> generateRecommendations(ColorProfileResult profile, Occasion occasion,
			SkinTone skinTone) {

		List<RecommendationRule> rules = ruleRepository.findBySourceCategory(profile.getColorCategory());

		List<RecommendationResult> results = new ArrayList<>();

		for (RecommendationRule rule : rules) {

			ColorCategory candidate = rule.getTargetCategory();

			double score = rule.getBaseScore();

			score += adjustForOccasion(candidate, occasion);
			score += adjustForSkinTone(candidate, skinTone);
			score += adjustForBrightness(profile.getBrightnessLevel(), candidate);
			score += applyFeedback(candidate);

			results.add(new RecommendationResult(candidate, score));
		}

		results.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));

		return results;
	}

	private double adjustForBrightness(BrightnessLevel brightness, ColorCategory candidate) {

		if (brightness == BrightnessLevel.LIGHT && candidate == ColorCategory.DARK)
			return 10;

		if (brightness == BrightnessLevel.DARK && candidate == ColorCategory.NEUTRAL)
			return 10;

		return 0;
	}

	private double adjustForSkinTone(ColorCategory candidate, SkinTone skinTone) {

		if (skinTone == null)
			return 0;

		switch (skinTone) {

		case LIGHT:
			if (candidate == ColorCategory.DARK)
				return 15;
			break;

		case MEDIUM:
			return 5;

		case DARK:
			if (candidate == ColorCategory.PASTEL || candidate == ColorCategory.NEUTRAL)
				return 15;
			break;
		}

		return 0;
	}

	private static final Map<ColorCategory, List<String>> categoryColorMap = Map.of(ColorCategory.NEUTRAL, List.of("Grey", "Beige"),
			ColorCategory.DARK, List.of("Black", "Navy"), ColorCategory.EARTH, List.of("Brown", "Olive"),
			ColorCategory.COOL, List.of("Blue", "Teal"), ColorCategory.WARM, List.of("Maroon", "Rust"),
			ColorCategory.PASTEL, List.of("Mint", "Light Blue"));

	private final FeedbackLearningService feedbackLearningService;

	public RecommendationEngine(RecommendationRuleRepository ruleRepository,
			FeedbackLearningService feedbackLearningService) {

		this.ruleRepository = ruleRepository;
		this.feedbackLearningService = feedbackLearningService;
	}
	
	private double applyFeedback(ColorCategory category) {

	    List<String> colors = categoryColorMap.get(category);

	    if (colors == null)
	        return 0;

	    double feedbackScore = 0;

	    for (String color : colors) {
	        feedbackScore += feedbackLearningService.getFeedbackScore(color);
	    }

	    // amplify learning impact
	    return feedbackScore * 5;
	}

	private double adjustForOccasion(ColorCategory candidate, Occasion occasion) {

		if (occasion == null)
			return 0;

		switch (occasion) {

		case OFFICE:
			if (candidate == ColorCategory.NEUTRAL || candidate == ColorCategory.DARK)
				return 20;
			return -10;

		case CASUAL:
			return 10;

		case PARTY:
			if (candidate == ColorCategory.WARM || candidate == ColorCategory.PASTEL)
				return 15;
			return 5;
		}

		return 0;
	}
}