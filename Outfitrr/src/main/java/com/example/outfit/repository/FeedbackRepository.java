package com.example.outfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.outfit.enums.ColorCategory;
import com.example.outfit.enums.Occasion;
import com.example.outfit.enums.SkinTone;
import com.example.outfit.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query("""
        SELECT COUNT(f)
        FROM Feedback f
        WHERE f.recommendedColor = :color
        AND f.liked = true
    """)
    long countLikes(@Param("color") String color);

    @Query("""
        SELECT COUNT(f)
        FROM Feedback f
        WHERE f.recommendedColor = :color
        AND f.liked = false
    """)
    long countDislikes(@Param("color") String color);
    
    boolean existsByUserIdAndBaseColorCategoryAndRecommendedColorAndOccasionAndSkinTone(
            Long userId,
            ColorCategory baseColorCategory,
            String recommendedColor,
            Occasion occasion,
            SkinTone skinTone
    );
}