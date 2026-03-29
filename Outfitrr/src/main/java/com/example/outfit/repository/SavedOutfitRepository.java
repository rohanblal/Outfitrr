package com.example.outfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.outfit.model.SavedOutfit;

public interface SavedOutfitRepository extends JpaRepository<SavedOutfit, Long> {

}