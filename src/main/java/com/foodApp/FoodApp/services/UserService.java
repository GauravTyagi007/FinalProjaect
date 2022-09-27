package com.foodApp.FoodApp.services;

import com.foodApp.FoodApp.dao.UserDao;
import com.foodApp.FoodApp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User addUser(User user)
    {
        return userDao.addUser(user);
    }

    public void deleteUser(int id)
    {
        userDao.deleteUser(id);
    }

    public List<User> getAllUser()
    {
        return userDao.getAllUsers();
    }

    public User updateUser(User user,int id)
    {
        return userDao.updateUser(user,id);
    }

    public User getUserById(int id)
    {
        return userDao.getById(id);
    }

    public User userLogin(User user)
    {
        return userDao.userLogin(user);
    }



}
