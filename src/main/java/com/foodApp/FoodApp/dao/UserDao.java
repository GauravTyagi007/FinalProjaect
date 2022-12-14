package com.foodApp.FoodApp.dao;

import com.foodApp.FoodApp.dto.User;
import com.foodApp.FoodApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    UserRepository userRepository;

   //@PostMapping("/saveUser")
    public User addUser(/*@RequestBody*/ User newUser)
    {
        String password=newUser.getPassword();
        String saltValue=PasswordEncryption.getSaltvalue(30);
        String encryptedPassword=PasswordEncryption.generateSecurePassword(password,saltValue);
        password=saltValue+encryptedPassword;
        newUser.setPassword(password);
        newUser.setEmail(newUser.getEmail().toLowerCase());
        return userRepository.save(newUser);

    }

    //@DeleteMapping("/users/{id}")
    public void deleteUser(/*@PathVariable*/ int id)
    {
        userRepository.deleteById(id);
        System.out.println("User Deleted for id" + id);
    }

    //@GetMapping("/showUsers")
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }


    //@PutMapping("/users/{id}")
    public User updateUser(/*@RequestBody*/ User updated_user, /*@PathVariable*/ int id)
    {
        String password=updated_user.getPassword();
        String saltValue=PasswordEncryption.getSaltvalue(30);
        String encryptedPassword=PasswordEncryption.generateSecurePassword(password,saltValue);
        password=saltValue+encryptedPassword;
        User user=getById(id);
        user.setName(updated_user.getName());
        user.setPassword(password);
        if(updated_user.getRole()!=null)
            user.setRole(updated_user.getRole());
        return userRepository.save(user);
    }

   // @GetMapping("/showUsers/{id}")
    public User getById(/*@PathVariable*/ int id)
    {
        return userRepository.findById(id).get();
    }


    public User getByEmail(String email)
    {
        return userRepository.getByEmail(email);
    }

    public User userLogin(User user)
    {
        User existing=getByEmail(user.getEmail().toLowerCase());
        System.out.println(existing);
        if(existing==null)
            return existing;
        if(PasswordEncryption.verifyUserPassword(user.getPassword(),existing.getPassword().substring(30),existing.getPassword().substring(0,30)))
            return existing;
        return null;
    }
    public User updateByManager(int user_id, String role) {
        // TODO Auto-generated method stub
        User user=getById(user_id);
        user.setRole(role);
        return userRepository.save(user);
    }



}
