package com.example.outfit.model;

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
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
	    uniqueConstraints = @UniqueConstraint(
	        columnNames = {
	            "user_id",
	            "base_color_category",
	            "recommended_color",
	            "occasion",
	            "skin_tone"
	        }
	    )
	)
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ColorCategory baseColorCategory;

    // specific pant color
    private String recommendedColor;

    @Enumerated(EnumType.STRING)
    private Occasion occasion;

    @Enumerated(EnumType.STRING)
    private SkinTone skinTone;

    private boolean liked;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Long getId() {
        return id;
    }

    public ColorCategory getBaseColorCategory() {
        return baseColorCategory;
    }

    public void setBaseColorCategory(ColorCategory baseColorCategory) {
        this.baseColorCategory = baseColorCategory;
    }

    public String getRecommendedColor() {
        return recommendedColor;
    }

    public void setRecommendedColor(String recommendedColor) {
        this.recommendedColor = recommendedColor;
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

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}