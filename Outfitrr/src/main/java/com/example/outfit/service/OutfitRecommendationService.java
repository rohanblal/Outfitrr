package com.example.outfit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.outfit.enums.Occasion;
import com.example.outfit.enums.SkinTone;

@Service
public class OutfitRecommendationService {

	@Autowired
	private ColorClassificationService colorClassificationService;

	@Autowired
	private RecommendationEngine recommendationEngine;

	public List<RecommendationResult> recommend(String hexColor, Occasion occasion, SkinTone skinTone) {

		// Step 1: classify color
		ColorProfileResult profile = colorClassificationService.classifyColor(hexColor);

		// Step 2: generate recommendations
		return recommendationEngine.generateRecommendations(profile, occasion, skinTone);
	}

	public List<RecommendationResult> recommendTop3(String hexColor, Occasion occasion, SkinTone skinTone) {

		List<RecommendationResult> results = recommend(hexColor, occasion, skinTone);

		return results.stream().limit(3).toList();
	}
}
