package com.foodApp.FoodApp.controller;

import com.foodApp.FoodApp.dto.Menu;
import com.foodApp.FoodApp.dto.User;
import com.foodApp.FoodApp.services.MenuService;
import com.foodApp.FoodApp.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/menu")
@Api(value="menu",description="menu CRUD operations")
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    UserService userService;


    @ApiOperation(value="Get list of all menu")
    @GetMapping(value="/getMenus")
    public List<Menu> getMenu()
    {
        return menuService.getAllMenu();
    }

    @ApiOperation(value="Get menu by menuId")
    @GetMapping(value="/getMenus/{id}")
    public Menu getMenuById(@PathVariable("id") int id)
    {
        return menuService.getMenuById(id);
    }

    @ApiOperation(value="Delete menu by menuId")
    @DeleteMapping(value="/getMenus/{id}")
    public void deleteMenu(@PathVariable("id") int id)
    {
        menuService.deleteMenu(id);
    }

    @ApiOperation(value="Add menu by userId")
    @PostMapping(value="/addMenu/{id}")
    public Menu addMenu(@RequestBody Menu menu,@PathVariable("id") int id)
    {
        User user=userService.getUserById(id);
        menu.setUser(user);
        return menuService.addMenu(menu);
    }


}
