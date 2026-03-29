package com.example.outfit.model;

import com.example.outfit.enums.ColorCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "recommendation_rules")
public class RecommendationRule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ColorCategory sourceCategory;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ColorCategory targetCategory;

	@Column(nullable = false)
	private double baseScore;

	public RecommendationRule() {
	}

	public RecommendationRule(ColorCategory sourceCategory, ColorCategory targetCategory, double baseScore) {
		this.sourceCategory = sourceCategory;
		this.targetCategory = targetCategory;
		this.baseScore = baseScore;
	}

	public Long getId() {
		return id;
	}

	public ColorCategory getSourceCategory() {
		return sourceCategory;
	}

	public void setSourceCategory(ColorCategory sourceCategory) {
		this.sourceCategory = sourceCategory;
	}

	public ColorCategory getTargetCategory() {
		return targetCategory;
	}

	public void setTargetCategory(ColorCategory targetCategory) {
		this.targetCategory = targetCategory;
	}

	public double getBaseScore() {
		return baseScore;
	}

	public void setBaseScore(double baseScore) {
		this.baseScore = baseScore;
	}
}