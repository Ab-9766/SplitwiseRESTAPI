package org.example.splitwise_application_spring.Controllers;

import org.example.splitwise_application_spring.DTOs.ResponseStatus;
import org.example.splitwise_application_spring.DTOs.SettleGroupRequestDTO;
import org.example.splitwise_application_spring.DTOs.SettleGroupResponseDTO;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    public SettleGroupResponseDTO settleGroup(SettleGroupRequestDTO settleGroupRequestDTO){
        SettleGroupResponseDTO responseDTO= new SettleGroupResponseDTO();
        responseDTO.setMessage("Not implemented yet");
        responseDTO.setResponseStatus(ResponseStatus.FAILURE);

        return responseDTO;
    }
}
