package com.foodApp.FoodApp.controller;

import com.foodApp.FoodApp.dto.Menu;
import com.foodApp.FoodApp.dto.User;
import com.foodApp.FoodApp.services.MenuService;
import com.foodApp.FoodApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    UserService userService;

    @GetMapping("/getMenus")
    public List<Menu> getMenu()
    {
        return menuService.getAllMenu();
    }

    @GetMapping("/getMenusById/{id}")
    public Menu getMenuById(@PathVariable("id") int id)
    {
        return menuService.getMenuById(id);
    }

    @DeleteMapping("/deleteMenus/{id}")
    public void deleteMenu(@PathVariable("id") int id)
    {
        menuService.deleteMenu(id);
    }

    @PostMapping("/addMenuWithUserId/{id}")
    public Menu addMenu(@RequestBody Menu menu,@PathVariable("id") int id)
    {
        User user=userService.getUserById(id);
        menu.setUser(user);
        return menuService.addMenu(menu);
    }


}
