package com.foodApp.FoodApp.repository;

import com.foodApp.FoodApp.dto.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodOrderRepository extends JpaRepository<FoodOrder,Integer> {

}
