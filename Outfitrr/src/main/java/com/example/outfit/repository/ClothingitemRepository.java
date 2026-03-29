//package com.example.outfit.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.example.outfit.enums.ColorCategory;
//import com.example.outfit.enums.Occasion;
//import com.example.outfit.model.ClothingItem;
//
//public interface ClothingitemRepository extends JpaRepository<ClothingItem, Long> {
//
//	List<ClothingItem> findByColorCategoryIn(List<ColorCategory> categories);
//
//	List<ClothingItem> findByColorCategoryInAndOccasion(List<ColorCategory> categories, Occasion occasion);
//}
