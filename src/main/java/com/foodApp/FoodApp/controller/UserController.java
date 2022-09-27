package com.foodApp.FoodApp.controller;


import com.foodApp.FoodApp.dto.Menu;
import com.foodApp.FoodApp.dto.User;
import com.foodApp.FoodApp.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(value="user",description="user CRUD operations")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MenuController menuController;


    @ApiOperation(value="Get List of all users")
    @GetMapping(value="/getUser")
    public List<User> getAllUser()
    {
        return userService.getAllUser();
    }

    @ApiOperation(value="Get user by Id")
    @GetMapping(value="/getUser/{id}")
    public User getUserById(@PathVariable("id") int id)
    {
        return userService.getUserById(id);
    }

    @ApiOperation(value="User Login")
    @PostMapping(value="/loginUser")
    public User userLogin(User user)
    {
        return userService.userLogin(user);
    }

    @ApiOperation(value="delete user by id")
    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable("id") int id)
    {
        userService.deleteUser(id);
        return "User Deleted for the given id"+id;
    }

    @ApiOperation(value="update user by id")
    @PutMapping(value="/updateUser/{id}")
    public User updateUser(@RequestBody User updatedUser,@PathVariable("id") int id)
    {
        return userService.updateUser(updatedUser,id);
    }

    @ApiOperation(value="add user")
    @PostMapping(value="/addUser")
    public User addUser(@RequestBody User user)
    {
        user=userService.addUser(user);
        Menu menu=new Menu();
        menuController.addMenu(menu, user.getId());
        return user;
    }



}
