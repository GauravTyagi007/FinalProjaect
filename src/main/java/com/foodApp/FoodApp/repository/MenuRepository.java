package com.foodApp.FoodApp.repository;

import com.foodApp.FoodApp.dto.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Integer> {

}
