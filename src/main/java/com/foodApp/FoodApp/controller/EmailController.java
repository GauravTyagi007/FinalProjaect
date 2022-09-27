package com.foodApp.FoodApp.controller;

import com.foodApp.FoodApp.dto.Email;
import com.foodApp.FoodApp.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Email emailDetails)
    {
        String status=emailService.sendMail(emailDetails);
        return status;
    }


}
