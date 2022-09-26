package com.foodApp.FoodApp.repository;

import com.foodApp.FoodApp.dto.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodProdRepository extends JpaRepository<FoodProduct,Integer> {
}
