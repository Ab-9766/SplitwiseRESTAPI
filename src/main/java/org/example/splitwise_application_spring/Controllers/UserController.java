package org.example.splitwise_application_spring.Controllers;

import org.example.splitwise_application_spring.DTOs.*;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    public CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO){
        CreateUserResponseDTO responseDTO= new CreateUserResponseDTO();
        responseDTO.setMessage("Not implemented yet");
        responseDTO.setResponseStatus(ResponseStatus.FAILURE);

        return responseDTO;
    }
    public GetUserResponseDTO getUser(GetUserRequestDTO getUserRequestDTO){
        GetUserResponseDTO responseDTO= new GetUserResponseDTO();
        responseDTO.setMessage("Not implemented yet");
        responseDTO.setResponseStatus(ResponseStatus.FAILURE);

        return responseDTO;
    }

}
