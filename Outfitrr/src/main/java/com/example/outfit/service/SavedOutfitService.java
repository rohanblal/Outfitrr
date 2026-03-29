package com.example.outfit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.outfit.model.SavedOutfit;
import com.example.outfit.model.User;
import com.example.outfit.repository.SavedOutfitRepository;
import com.example.outfit.repository.UserRepository;
import com.example.outfit.security.JwtUtil;

@Service
public class SavedOutfitService {

	@Autowired
	private SavedOutfitRepository savedOutfitRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	public SavedOutfit saveOutfit(SavedOutfit outfit, String token) {

	    String email = jwtUtil.extractEmail(token.substring(7));

	    User user = userRepository.findByEmail(email);

	    if (user == null) {
	        throw new RuntimeException("User not found");
	    }

	    outfit.setUser(user);

	    return savedOutfitRepository.save(outfit);
	}

	public List<SavedOutfit> getAllSavedOutfits() {
		return savedOutfitRepository.findAll();
	}

	public void deleteSavedOutfit(Long id) {
		savedOutfitRepository.deleteById(id);
	}
}