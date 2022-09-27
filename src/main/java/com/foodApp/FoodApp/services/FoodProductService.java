package com.foodApp.FoodApp.services;

import com.foodApp.FoodApp.dao.FoodProductDao;
import com.foodApp.FoodApp.dto.FoodProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodProductService {

    @Autowired
    FoodProductDao foodProductDao;


    public FoodProduct addProduct(FoodProduct product) { return foodProductDao.addProduct(product); }

    public void deleteProduct(int id) {
        foodProductDao.deleteProduct(id);
    }

    public List<FoodProduct> getAllProduct() {
        return foodProductDao.getAllProduct();
    }

    public FoodProduct updateProduct(FoodProduct product) {
        return foodProductDao.updateProduct(product);
    }


}
