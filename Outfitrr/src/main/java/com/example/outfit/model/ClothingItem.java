//package com.example.outfit.model;
//
//import com.example.outfit.enums.ColorCategory;
//import com.example.outfit.enums.Occasion;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class ClothingItem {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String name;
//	@Enumerated(EnumType.STRING)
//	private ColorCategory colorCategory;
//	@Enumerated(EnumType.STRING)
//	private Occasion occasion;
//	private String imageUrl;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public ColorCategory getColorCategory() {
//		return colorCategory;
//	}
//
//	public void setColorCategory(ColorCategory colorCategory) {
//		this.colorCategory = colorCategory;
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
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//
//}
