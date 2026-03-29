package com.example.outfit.service;

import com.example.outfit.enums.BrightnessLevel;
import com.example.outfit.enums.ColorCategory;
import com.example.outfit.enums.SaturationLevel;

public class ColorProfileResult {
	private ColorCategory colorCategory;
	private BrightnessLevel brightnessLevel;
	private SaturationLevel saturationLevel;

	public ColorProfileResult(ColorCategory colorCategory, BrightnessLevel brightnessLevel,
			SaturationLevel saturationLevel) {
		this.colorCategory = colorCategory;
		this.brightnessLevel = brightnessLevel;
		this.saturationLevel = saturationLevel;
	}

	public ColorCategory getColorCategory() {
		return colorCategory;
	}

	public BrightnessLevel getBrightnessLevel() {
		return brightnessLevel;
	}

	public SaturationLevel getSaturationLevel() {
		return saturationLevel;
	}

}
