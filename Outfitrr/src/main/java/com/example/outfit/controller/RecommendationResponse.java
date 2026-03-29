package com.example.outfit.controller;

import com.example.outfit.enums.ColorCategory;

public class RecommendationResponse {

	private ColorCategory colorCategory;
	private double score;
	
	public RecommendationResponse(ColorCategory colorCategory, double score) {
		this.colorCategory = colorCategory;
		this.score = score;
	}

	public ColorCategory getColorCategory() {
		return colorCategory;
	}



	public double getScore() {
		return score;
	}
	
}
