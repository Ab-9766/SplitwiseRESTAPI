package org.example.splitwise_application_spring.Commands;

import org.example.splitwise_application_spring.Controllers.UserController;
import org.example.splitwise_application_spring.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserCommand implements Command{
    private UserController userController;


    @Autowired
    public GetUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("get-user")){
            return false;
        }
        if(input.split(" ").length!=2){
            return false;
        }
        return true;
    }

    @Override
    public void Execute(String input) {
        //Make DTO and call controller
        String[] parts=input.split(" ");

        GetUserRequestDTO requestDTO = new GetUserRequestDTO();
        requestDTO.setUserId(Long.parseLong(parts[1]));

        GetUserResponseDTO responseDTO= userController.getUser(Long.parseLong(parts[1]));

        if(responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println("User = "+ responseDTO.getName());
            System.out.println("User Name= "+ responseDTO.getUsername());
        }
        else{
            System.out.println("User retrieval failed with message "+ responseDTO.getMessage());
        }
    }
}
