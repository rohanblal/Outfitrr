package com.example.outfit.repository;

import com.example.outfit.enums.ColorCategory;
import com.example.outfit.model.RecommendationRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRuleRepository
        extends JpaRepository<RecommendationRule, Long> {

    List<RecommendationRule> findBySourceCategory(ColorCategory sourceCategory);

}