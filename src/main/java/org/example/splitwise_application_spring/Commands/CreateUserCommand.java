package org.example.splitwise_application_spring.Commands;

import org.example.splitwise_application_spring.Controllers.UserController;
import org.example.splitwise_application_spring.DTOs.CreateUserRequestDTO;
import org.example.splitwise_application_spring.DTOs.CreateUserResponseDTO;
import org.example.splitwise_application_spring.DTOs.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommand implements Command{
    private UserController userController;

    @Autowired
    public CreateUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("create-user")){
            return false;
        }
        if(input.split(" ").length!=4){
            return false;
        }
        return true;
    }

    @Override
    public void Execute(String input) {
        //Make DTO and call controller
        String[] parts=input.split(" ");
        CreateUserRequestDTO requestDTO = new CreateUserRequestDTO();
        requestDTO.setName(parts[1]);
        requestDTO.setUsername(parts[2]);
        requestDTO.setPwd(parts[3]);

        CreateUserResponseDTO responseDTO= userController.createUser(requestDTO);

        if(responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println("User created successfully with id "+ responseDTO.getUserId());
        }
        else{
            System.out.println("User creation failed with message "+ responseDTO.getMessage());
        }
    }
}
