package com.foodApp.FoodApp.dao;

import com.foodApp.FoodApp.dto.FoodProduct;
import com.foodApp.FoodApp.repository.FoodProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodProductDao {

    @Autowired
    FoodProdRepository foodProdRepository;

    public FoodProduct addProduct(FoodProduct product) {
        return foodProdRepository.save(product);
    }

    public void deleteProduct(int id) {
        foodProdRepository.deleteById(id);
    }

    public List<FoodProduct> getAllProduct() {
        return foodProdRepository.findAll();
    }

    public FoodProduct updateProduct(FoodProduct product) {
        return foodProdRepository.save(product);
    }


}
