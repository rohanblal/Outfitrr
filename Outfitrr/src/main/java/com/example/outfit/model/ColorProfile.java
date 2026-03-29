//package com.example.outfit.model;
//
//import com.example.outfit.enums.BrightnessLevel;
//import com.example.outfit.enums.ColorCategory;
//import com.example.outfit.enums.SaturationLevel;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class ColorProfile {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String hexCode;
//	
//	@Enumerated(EnumType.STRING)
//	private ColorCategory colorCategory;
//	@Enumerated(EnumType.STRING)
//	private BrightnessLevel brightnessLevel;
//	@Enumerated(EnumType.STRING)
//	private SaturationLevel saturationLevel;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getHexCode() {
//		return hexCode;
//	}
//	public void setHexCode(String hexCode) {
//		this.hexCode = hexCode;
//	}
//	public ColorCategory getColorCategory() {
//		return colorCategory;
//	}
//	public void setColorCategory(ColorCategory colorCategory) {
//		this.colorCategory = colorCategory;
//	}
//	public BrightnessLevel getBrightnessLevel() {
//		return brightnessLevel;
//	}
//	public void setBrightnessLevel(BrightnessLevel brightnessLevel) {
//		this.brightnessLevel = brightnessLevel;
//	}
//	public SaturationLevel getSaturationLevel() {
//		return saturationLevel;
//	}
//	public void setSaturationLevel(SaturationLevel saturationLevel) {
//		this.saturationLevel = saturationLevel;
//	}
//	public ColorProfile(Long id, String hexCode, ColorCategory colorCategory, BrightnessLevel brightnessLevel,
//			SaturationLevel saturationLevel) {
//		super();
//		this.id = id;
//		this.hexCode = hexCode;
//		this.colorCategory = colorCategory;
//		this.brightnessLevel = brightnessLevel;
//		this.saturationLevel = saturationLevel;
//	}
//	public ColorProfile() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//}
