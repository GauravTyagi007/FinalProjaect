package com.foodApp.FoodApp.controller;

import com.foodApp.FoodApp.dto.Email;
import com.foodApp.FoodApp.dto.FoodOrder;
import com.foodApp.FoodApp.dto.User;
import com.foodApp.FoodApp.services.EmailServiceImplementation;
import com.foodApp.FoodApp.services.FoodOrderService;
import com.foodApp.FoodApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/foodOrder")
public class FoodOrderController {

    @Autowired
    FoodOrderService foodOrderService;

    @Autowired
    UserService userService;

    @Autowired
    private EmailServiceImplementation emailServiceImplementation;

    @GetMapping("/order/{id}")
    public List<FoodOrder> getOrderByUserId(@PathVariable("id") int id)
    {
        User user=userService.getUserById(id);
        return user.getFoodOrder();
    }
    @PostMapping("/addOrder/{id}")
    public FoodOrder addOrder(@RequestBody FoodOrder order, @PathVariable("id") int user_id) {
        User user = userService.getUserById(user_id);
        order.setUser(user);
        return foodOrderService.addOrder(order);
    }

    @PutMapping("/updateOrder/{id}")
    public FoodOrder updateOrder(@RequestBody FoodOrder order,@PathVariable("id") int id) {
        FoodOrder updated_order=foodOrderService.updateOrder(order);;
        User user=userService.getUserById(id);
        Email details=new Email();
        details.setRecipient(user.getEmail());
        details.setMsgBody(updated_order.toString());
        details.setSubject("Order finalized for Customer with name : "+updated_order.getCustomerName());
        System.out.println(emailServiceImplementation.sendMail(details));
        return updated_order;
    }

    @DeleteMapping("/delete/order/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        return foodOrderService.deleteOrder(id);
    }

    @GetMapping("getOrderById/{id}")
    public FoodOrder getOrderByOrderId(@PathVariable("id") int id) {
        return foodOrderService.getFoodOrderById(id);
    }

}
