package com.foodApp.FoodApp.controller;


import com.foodApp.FoodApp.dto.Menu;
import com.foodApp.FoodApp.dto.User;
import com.foodApp.FoodApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MenuController menuController;

    @GetMapping("/getUser")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable("id") int id)
    {
        return userService.getUserById(id);
    }

    @PostMapping("/loginUser")
    public User userLogin(User user)
    {
        return userService.userLogin(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id)
    {
        userService.deleteUser(id);
        return "User Deleted for the given id"+id;
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@RequestBody User updatedUser,@PathVariable("id") int id)
    {
        return userService.updateUser(updatedUser,id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        user=userService.addUser(user);
        Menu menu=new Menu();
        menuController.addMenu(menu, user.getId());
        return user;
    }



}
