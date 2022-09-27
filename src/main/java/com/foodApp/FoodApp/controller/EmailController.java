package com.foodApp.FoodApp.controller;

import com.foodApp.FoodApp.dto.Email;
import com.foodApp.FoodApp.services.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/email")
@Api(value="email",description="email CRUD operations")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @ApiOperation(value="Send email")
    @PostMapping(value="/sendEmail")
    public String sendEmail(@RequestBody Email emailDetails)
    {
        String status=emailService.sendMail(emailDetails);
        return status;
    }


}
