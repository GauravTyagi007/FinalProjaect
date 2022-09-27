package com.foodApp.FoodApp.services;

import com.foodApp.FoodApp.dao.FoodOrderDao;
import com.foodApp.FoodApp.dto.FoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderService {

    @Autowired
    FoodOrderDao foodOrderDao;

    public FoodOrder addOrder(FoodOrder order)
    {
        return foodOrderDao.addOrder(order);
    }

    public FoodOrder updateOrder(FoodOrder newOrder)
    {
        return foodOrderDao.updateOrder(newOrder);
    }
    public FoodOrder getOrderById(int id)
    {
        return foodOrderDao.getOrderById(id);
    }
    public String deleteOrder(int id)
    {
        return foodOrderDao.deleteOrder(id);
    }
    public FoodOrder getFoodOrderById(int id)
    {
        return foodOrderDao.getFoodOrderById(id);
    }


}
