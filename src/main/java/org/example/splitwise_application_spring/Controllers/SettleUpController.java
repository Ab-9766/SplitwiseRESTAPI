package org.example.splitwise_application_spring.Controllers;

import org.example.splitwise_application_spring.DTOs.SettleUserRequestDTO;
import org.example.splitwise_application_spring.DTOs.SettleUserResponseDTO;
import org.example.splitwise_application_spring.Models.Transaction;
import org.example.splitwise_application_spring.Services.IUserSettleUpService;
import org.example.splitwise_application_spring.Services.UserSettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController implements IUserSettleUpService {

    private IUserSettleUpService service;

    @Autowired
    public SettleUpController(IUserSettleUpService service) {
        this.service = service;
    }

    public SettleUserResponseDTO settleUpUser(SettleUserRequestDTO settleUserRequestDTO){

    List<Transaction> transaction=service.settleUpUser(settleUserRequestDTO.getUserId());
    SettleUserResponseDTO responseDTO= mapExpenseToDTO(transaction);
    return responseDTO;
    }

    private SettleUserResponseDTO mapExpenseToDTO(List<Transaction> transaction) {

        return new SettleUserResponseDTO();
    }
}
