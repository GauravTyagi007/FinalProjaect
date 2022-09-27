package com.foodApp.FoodApp.controller;

import com.foodApp.FoodApp.dto.FoodProduct;
import com.foodApp.FoodApp.dto.Menu;
import com.foodApp.FoodApp.dto.User;
import com.foodApp.FoodApp.services.FoodProductService;
import com.foodApp.FoodApp.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/foodProduct")
@Api(value="foodProduct",description="foodProduct CRUD operations")
public class FoodProductController {

    @Autowired
    FoodProductService foodProductService;

    @Autowired
    UserService userService;


    @ApiOperation(value="Add product by userId")
    @PostMapping(value="/addProduct/{user_id}")
    public FoodProduct addProduct(@RequestBody FoodProduct product , @PathVariable int user_id) {
        User user = userService.getUserById(user_id);
        Menu menu=user.getMenu();
        product.setMenu(menu);
        return foodProductService.addProduct(product);
    }

    @ApiOperation(value="Delete product by id")
    @DeleteMapping(value="/deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        foodProductService.deleteProduct(id);
    }

    @ApiOperation(value="Get list of All products")
    @GetMapping(value="/getProduct")
    public List<FoodProduct> getProduct() {
        return foodProductService.getAllProduct();
    }

    @ApiOperation(value="Update product")
    @PutMapping(value="/updateProduct")
    public FoodProduct updateProduct(@RequestBody FoodProduct product) {
        return foodProductService.updateProduct(product);
    }

}
