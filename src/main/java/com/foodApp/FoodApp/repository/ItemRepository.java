package com.foodApp.FoodApp.repository;

import com.foodApp.FoodApp.dto.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
