package com.example.outfit.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.outfit.service.OutfitRecommendationService;
import com.example.outfit.service.RecommendationResult;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/recommend")
public class RecommendationController {

	@Autowired
	private OutfitRecommendationService recommendationService;

	@PostMapping
	public List<RecommendationResponse> recommend(@Valid @RequestBody RecommendationRequest request) {
		List<RecommendationResult> results = recommendationService.recommend(request.getHexColor(),
				request.getOccasion(), request.getSkinTone());

		return results.stream().map(r -> new RecommendationResponse(r.getRecommendedCategory(), r.getScore()))
				.collect(Collectors.toList());
	}

	@PostMapping("/top3")
	public List<RecommendationResponse> recommendTop3(@Valid @RequestBody RecommendationRequest request) {

		List<RecommendationResult> results = recommendationService.recommendTop3(request.getHexColor(),
				request.getOccasion(), request.getSkinTone());

		return results.stream().map(r -> new RecommendationResponse(r.getRecommendedCategory(), r.getScore()))
				.collect(Collectors.toList());
	}
}
