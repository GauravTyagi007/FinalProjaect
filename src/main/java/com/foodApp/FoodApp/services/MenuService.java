package com.foodApp.FoodApp.services;

import com.foodApp.FoodApp.dao.MenuDao;
import com.foodApp.FoodApp.dto.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;

    public Menu addMenu(Menu menu)
    {
        return menuDao.addMenu(menu);
    }

    public void deleteMenu(int id)
    {
        menuDao.deleteMenu(id);
    }

    public List<Menu> getAllMenu()
    {
        return menuDao.getAllMenu();
    }

    public Menu getMenuById(int id)
    {
        return menuDao.getMenuById(id);
    }
}
