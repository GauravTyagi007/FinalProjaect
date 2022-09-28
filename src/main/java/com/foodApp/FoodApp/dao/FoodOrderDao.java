package com.foodApp.FoodApp.dao;

import com.foodApp.FoodApp.dto.FoodOrder;
import com.foodApp.FoodApp.repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodOrderDao {

    @Autowired
    FoodOrderRepository foodOrderRepository;

    public FoodOrder addOrder(FoodOrder order) {
        // TODO Auto-generated method stub
        order.setOrderCreatetime(new java.util.Date() + "");
        return foodOrderRepository.save(order);
    }

    public FoodOrder updateOrder(FoodOrder order) {
        // TODO Auto-generated method stub
        FoodOrder foodOrder = getOrderById(order.getId());
        foodOrder.setTotalPrice(order.getTotalPrice());
        foodOrder.setOrderDeliverytime(new java.util.Date() + "");
        foodOrder.setContactNumber(order.getContactNumber());
        foodOrder.setStatus(true);
        return foodOrderRepository.save(foodOrder);
    }

    public FoodOrder getOrderById(int id) {
        // TODO Auto-generated method stub
        return foodOrderRepository.findById(id).get();
    }

    public String deleteOrder(int id) {
        // TODO Auto-generated method stub
        FoodOrder order = getOrderById(id);
        if (order != null) {
            foodOrderRepository.delete(order);
            return order.getCustomerName() + "the order is deleted";
        }
        else
        {
            return "No order is deleted";
        }
    }

    public FoodOrder getFoodOrderById(int orderId) {
        // TODO Auto-generated method stub
        FoodOrder order = getOrderById(orderId);
        return order;
    }

}
