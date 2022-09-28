package com.foodApp.FoodApp.controller;

import com.foodApp.FoodApp.dto.FoodProduct;
import com.foodApp.FoodApp.dto.Menu;
import com.foodApp.FoodApp.dto.User;
import com.foodApp.FoodApp.services.FoodProductService;
import com.foodApp.FoodApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodProduct")
public class FoodProductController {

    @Autowired
    FoodProductService foodProductService;

    @Autowired
    UserService userService;


    @PostMapping("/addProduct/{user_id}")
    public FoodProduct addProduct(@RequestBody FoodProduct product , @PathVariable int user_id) {
        User user = userService.getUserById(user_id);
        Menu menu=user.getMenu();
        product.setMenu(menu);
        return foodProductService.addProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        foodProductService.deleteProduct(id);
    }

    @GetMapping("/getProduct")
    public List<FoodProduct> getProduct() {
        return foodProductService.getAllProduct();
    }

    @PutMapping("/updateProduct")
    public FoodProduct updateProduct(@RequestBody FoodProduct product) {
        return foodProductService.updateProduct(product);
    }

}
