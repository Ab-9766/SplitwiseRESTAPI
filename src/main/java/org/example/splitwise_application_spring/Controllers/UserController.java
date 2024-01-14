package org.example.splitwise_application_spring.Controllers;

import org.example.splitwise_application_spring.DTOs.*;
import org.example.splitwise_application_spring.DTOs.ResponseStatus;
import org.example.splitwise_application_spring.Models.User;
import org.example.splitwise_application_spring.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create/")
    public CreateUserResponseDTO createUser(@RequestBody CreateUserRequestDTO requestDTO){
        CreateUserResponseDTO responseDTO= new CreateUserResponseDTO();

        try{
            User savedUser= userService.createUser(requestDTO.getName(),requestDTO.getUsername(),requestDTO.getPwd());
            responseDTO.setMessage("User created successfully");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setUserId(savedUser.getId());


        } catch (Exception e) {
            responseDTO.setMessage(e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    @GetMapping("/user/get/")
    public GetUserResponseDTO getUser(@RequestParam Long userID){ //With requestParam
        //directly used userID, NO NEED OF DTO

        GetUserResponseDTO responseDTO= new GetUserResponseDTO();

        try{
            User user= userService.getUser(userID);
            responseDTO.setMessage("User found successfully");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setName(user.getName());
            responseDTO.setUsername(user.getUserName());

        } catch (Exception e) {
            responseDTO.setMessage(e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

}
