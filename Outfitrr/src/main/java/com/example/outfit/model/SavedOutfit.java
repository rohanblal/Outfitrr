package com.example.outfit.model;

import java.time.LocalDateTime;

import com.example.outfit.enums.ColorCategory;
import com.example.outfit.enums.Occasion;
import com.example.outfit.enums.SkinTone;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SavedOutfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shirtColorHex;

    private String pantColor;   // Beige, Grey, Black etc.

    @Enumerated(EnumType.STRING)
    private Occasion occasion;

    @Enumerated(EnumType.STRING)
    private SkinTone skinTone;

    private LocalDateTime savedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShirtColorHex() {
		return shirtColorHex;
	}

	public void setShirtColorHex(String shirtColorHex) {
		this.shirtColorHex = shirtColorHex;
	}

	public String getPantColor() {
		return pantColor;
	}

	public void setPantColor(String pantColor) {
		this.pantColor = pantColor;
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

	public LocalDateTime getSavedAt() {
		return savedAt;
	}

	public void setSavedAt(LocalDateTime savedAt) {
		this.savedAt = savedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SavedOutfit(Long id, String shirtColorHex, String pantColor, Occasion occasion, SkinTone skinTone,
			LocalDateTime savedAt, User user) {
		super();
		this.id = id;
		this.shirtColorHex = shirtColorHex;
		this.pantColor = pantColor;
		this.occasion = occasion;
		this.skinTone = skinTone;
		this.savedAt = savedAt;
		this.user = user;
	}

	public SavedOutfit() {
		super();
		// TODO Auto-generated constructor stub
	}
}