package com.example.outfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.outfit.model.SavedOutfit;
import com.example.outfit.service.SavedOutfitService;

@RestController
@RequestMapping("/api/outfits")
public class SavedOutfitController {

    @Autowired
    private SavedOutfitService savedOutfitService;

    // Save an outfit
    @PostMapping("/save")
    public SavedOutfit saveOutfit(
            @RequestBody SavedOutfit outfit,
            @RequestHeader("Authorization") String token) {

        return savedOutfitService.saveOutfit(outfit, token);
    }

    // Get all saved outfits
    @GetMapping
    public List<SavedOutfit> getAllOutfits() {
        return savedOutfitService.getAllSavedOutfits();
    }

    // Delete outfit
    @DeleteMapping("/{id}")
    public String deleteOutfit(@PathVariable Long id) {
        savedOutfitService.deleteSavedOutfit(id);
        return "Outfit deleted successfully";
    }
}