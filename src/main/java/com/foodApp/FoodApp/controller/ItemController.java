package com.foodApp.FoodApp.controller;

import com.foodApp.FoodApp.dto.FoodOrder;
import com.foodApp.FoodApp.dto.Item;
import com.foodApp.FoodApp.services.FoodOrderService;
import com.foodApp.FoodApp.services.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/item")
@Api(value="item",description="item CRUD operations")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    FoodOrderService foodOrderService;

    @ApiOperation(value="Add item by orderId")
    @PostMapping(value="/addItem/{order_id}")
    public Item addItem(@RequestBody Item item, @PathVariable("order_id") int order_id) {
        FoodOrder foodOrder=foodOrderService.getFoodOrderById(order_id);
        item.setFoodOrder(foodOrder);
        return itemService.addItem(item);
    }

    @ApiOperation(value="delete item by id")
    @DeleteMapping(value="/deleteItem/{id}")
    public String deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
        return "Deleted User with Id : "+id;
    }

    @ApiOperation(value="update item")
    @PutMapping(value="/updateItem")
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @ApiOperation(value="Get list of All items")
    @GetMapping(value="/getItems")
    public List<Item> getItems() {
        return itemService.getAllItem();
    }

    @ApiOperation(value="Get item by id")
    @GetMapping(value="/getItems/{id}")
    public Item getItemsById(@PathVariable("id") int id) {
        return itemService.getItemById(id);
    }


}
