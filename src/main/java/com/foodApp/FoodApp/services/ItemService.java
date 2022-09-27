package com.foodApp.FoodApp.services;

import com.foodApp.FoodApp.dao.ItemDao;
import com.foodApp.FoodApp.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;

    public Item addItem(Item newItem) {
        return itemDao.addItem(newItem);
    }

    public void deleteItem(int id) {
        itemDao.deleteItem(id);
    }

    public List<Item> getAllItem() {
        return itemDao.getAllItem();
    }

    public Item getItemById(int id) {
        return itemDao.getItemById(id);
    }

    public Item updateItem(Item updatedItem) {
        return itemDao.updateItem(updatedItem);
    }
}
