package com.foodApp.FoodApp.dao;

import com.foodApp.FoodApp.dto.Menu;
import com.foodApp.FoodApp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuDao {

    @Autowired
    MenuRepository menuRepository;

    public Menu addMenu(Menu menu)
    {
            return menuRepository.save(menu);
    }
    public void deleteMenu(int id)
    {
        menuRepository.deleteById(id);
        System.out.println("Menu Deleted for id: " + id);
    }
    public Menu getMenuById(int id)
    {
        return menuRepository.findById(id).get();
    }
    public List<Menu> getAllMenu()
    {
        return menuRepository.findAll();
    }
}
