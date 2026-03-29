package com.example.outfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.outfit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}