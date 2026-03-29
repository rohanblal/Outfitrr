//package com.example.outfit.model;
//
//import com.example.outfit.enums.ColorCategory;
//import com.example.outfit.enums.Occasion;
//import com.example.outfit.enums.SkinTone;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//@Entity
//public class OutfitRecommendation {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@Enumerated(EnumType.STRING)
//	private ColorCategory baseColorCategory;
//	@Enumerated(EnumType.STRING)
//	private ColorCategory recommendedColorCategory;
//	@Enumerated(EnumType.STRING)
//	private Occasion occasion;
//	@Enumerated(EnumType.STRING)
//	private SkinTone skinTone;
//	
//	private Double compatibilityScore;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public ColorCategory getBaseColorCategory() {
//		return baseColorCategory;
//	}
//
//	public void setBaseColorCategory(ColorCategory baseColorCategory) {
//		this.baseColorCategory = baseColorCategory;
//	}
//
//	public ColorCategory getRecommendedColorCategory() {
//		return recommendedColorCategory;
//	}
//
//	public void setRecommendedColorCategory(ColorCategory recommendedColorCategory) {
//		this.recommendedColorCategory = recommendedColorCategory;
//	}
//
//	public Occasion getOccasion() {
//		return occasion;
//	}
//
//	public void setOccasion(Occasion occasion) {
//		this.occasion = occasion;
//	}
//
//	public SkinTone getSkinTone() {
//		return skinTone;
//	}
//
//	public void setSkinTone(SkinTone skinTone) {
//		this.skinTone = skinTone;
//	}
//
//	public Double getCompatibilityScore() {
//		return compatibilityScore;
//	}
//
//	public void setCompatibilityScore(Double compatibilityScore) {
//		this.compatibilityScore = compatibilityScore;
//	}
//
//	public OutfitRecommendation(Long id, ColorCategory baseColorCategory, ColorCategory recommendedColorCategory,
//			Occasion occasion, SkinTone skinTone, Double compatibilityScore) {
//		super();
//		this.id = id;
//		this.baseColorCategory = baseColorCategory;
//		this.recommendedColorCategory = recommendedColorCategory;
//		this.occasion = occasion;
//		this.skinTone = skinTone;
//		this.compatibilityScore = compatibilityScore;
//	}
//
//	public OutfitRecommendation() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//}
