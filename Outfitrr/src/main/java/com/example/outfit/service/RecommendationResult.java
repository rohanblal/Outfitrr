package com.example.outfit.service;

import com.example.outfit.enums.ColorCategory;

public class RecommendationResult {
	private ColorCategory recommendedCategory;
	private double score;

	public RecommendationResult(ColorCategory recommendedCategory, double score) {

		this.recommendedCategory = recommendedCategory;
		this.score = score;
	}

	public ColorCategory getRecommendedCategory() {
		return recommendedCategory;
	}

	public double getScore() {
		return score;
	}

}
