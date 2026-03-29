package com.example.outfit.service;

import org.springframework.stereotype.Service;

import com.example.outfit.enums.BrightnessLevel;
import com.example.outfit.enums.ColorCategory;
import com.example.outfit.enums.SaturationLevel;
@Service
public class ColorClassificationService {

	public ColorProfileResult classifyColor(String hex) {
		int[] rgb = hexToRgb(hex);
		int r = rgb[0];
		int g = rgb[1];
		int b = rgb[2];

		BrightnessLevel brightness = classifyBrightness(r, g, b);
		SaturationLevel saturation = classifySaturation(r, g, b);
		ColorCategory category = classifyCategory(r, g, b, brightness, saturation);

		return new ColorProfileResult(category, brightness, saturation);
	}

	private int[] hexToRgb(String hex) {
		hex = hex.replace("#", "");
		int r = Integer.parseInt(hex.substring(0, 2), 16);
		int g = Integer.parseInt(hex.substring(2, 4), 16);
		int b = Integer.parseInt(hex.substring(4, 6), 16);
		return new int[] { r, g, b };
	}

	private BrightnessLevel classifyBrightness(int r, int g, int b) {
		int average = (r + g + b) / 3;

		if (average < 85) {
			return BrightnessLevel.DARK;
		} else if (average < 170) {
			return BrightnessLevel.MEDIUM;
		} else {
			return BrightnessLevel.LIGHT;
		}
	}

	private SaturationLevel classifySaturation(int r, int g, int b) {
		int max = Math.max(r, Math.max(g, b));
		int min = Math.min(r, Math.min(g, b));

		int difference = max - min;

		if (difference < 50) {
			return SaturationLevel.LOW;
		} else if (difference < 150) {
			return SaturationLevel.MEDIUM;
		} else {
			return SaturationLevel.HIGH;
		}
	}

	private ColorCategory classifyCategory(int r, int g, int b,
	        BrightnessLevel brightness,
	        SaturationLevel saturation) {

	    int max = Math.max(r, Math.max(g, b));
	    int min = Math.min(r, Math.min(g, b));

	    // Neutral colors (gray, white, black)
	    if (Math.abs(r - g) < 15 && Math.abs(g - b) < 15) {
	        return ColorCategory.NEUTRAL;
	    }

	    // Earth tones (brownish shades)
	    if (r > 100 && g > 80 && b < 80) {
	        return ColorCategory.EARTH;
	    }

	    // Warm colors (red/orange dominant)
	    if (r - b > 40 && r - g > 20) {
	        return ColorCategory.WARM;
	    }

	    // Cool colors (blue dominant)
	    if (b - r > 40 && b - g > 20) {
	        return ColorCategory.COOL;
	    }

	    // Pastel colors
	    if (brightness == BrightnessLevel.LIGHT &&
	        saturation == SaturationLevel.LOW) {
	        return ColorCategory.PASTEL;
	    }

	    // Dark colors
	    if (brightness == BrightnessLevel.DARK) {
	        return ColorCategory.DARK;
	    }

	    return ColorCategory.NEUTRAL;
	}
}
