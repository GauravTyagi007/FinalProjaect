package com.foodApp.FoodApp.repository;

import com.foodApp.FoodApp.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


    public User getByEmail(String email);


}
