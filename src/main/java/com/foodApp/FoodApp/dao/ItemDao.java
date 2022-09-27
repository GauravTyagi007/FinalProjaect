package com.foodApp.FoodApp.dao;

import com.foodApp.FoodApp.dto.Item;
import com.foodApp.FoodApp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItem()
    {
        return itemRepository.findAll();
    }

    public Item getItemById(int id)
    {
        return itemRepository.findById(id).get();
    }
    public void deleteItem(int id)
    {
        itemRepository.deleteById(id);
    }
    public Item addItem(Item newItem)
    {
        return itemRepository.save(newItem);
    }
    public Item updateItem(Item updatedItem)
    {
        return itemRepository.save(updatedItem);
    }

}
