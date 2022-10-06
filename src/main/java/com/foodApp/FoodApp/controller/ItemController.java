package com.foodApp.FoodApp.controller;

import com.foodApp.FoodApp.dto.FoodOrder;
import com.foodApp.FoodApp.dto.Item;
import com.foodApp.FoodApp.services.FoodOrderService;
import com.foodApp.FoodApp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    FoodOrderService foodOrderService;

    @PostMapping("/addItem/{order_id}")
    public Item addItem(@RequestBody Item item, @PathVariable("order_id") int order_id) {
        FoodOrder foodOrder=foodOrderService.getFoodOrderById(order_id);
        item.setFoodOrder(foodOrder);
        return itemService.addItem(item);
    }

    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
        return "Deleted User with Id : "+id;
    }

    @PutMapping("/updateItem")
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @GetMapping("/getItems")
    public List<Item> getItems() {
        return itemService.getAllItem();
    }

    @GetMapping("/getItems/{id}")
    public Item getItemsById(@PathVariable("id") int id) {
        return itemService.getItemById(id);
    }


}
