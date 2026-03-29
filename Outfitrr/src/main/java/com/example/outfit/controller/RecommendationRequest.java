package com.example.outfit.controller;

import com.example.outfit.enums.Occasion;
import com.example.outfit.enums.SkinTone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RecommendationRequest {
	@NotBlank
	@Pattern(regexp = "^#([A-Fa-f0-9]{6})$", message = "Invalid HEX color")
	 private String hexColor;
	 @NotNull
	 private Occasion occasion;
	 
	 private SkinTone skinTone;

	public String getHexColor() {
		return hexColor;
	}

	public void setHexColor(String hexColor) {
		this.hexColor = hexColor;
	}

	public Occasion getOccasion() {
		return occasion;
	}

	public void setOccasion(Occasion occasion) {
		this.occasion = occasion;
	}

	public SkinTone getSkinTone() {
		return skinTone;
	}

	public void setSkinTone(SkinTone skinTone) {
		this.skinTone = skinTone;
	}
}
