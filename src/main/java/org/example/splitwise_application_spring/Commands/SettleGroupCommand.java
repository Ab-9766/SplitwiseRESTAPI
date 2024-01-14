package org.example.splitwise_application_spring.Commands;


import jakarta.transaction.Transaction;
import org.example.splitwise_application_spring.Controllers.GroupController;
import org.example.splitwise_application_spring.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleGroupCommand implements Command{
    private GroupController groupController;

    @Autowired
    public SettleGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("settle-group")){
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

        SettleGroupRequestDTO requestDTO = new SettleGroupRequestDTO();
        requestDTO.setGroupName(parts[1]);


        SettleGroupResponseDTO responseDTO= groupController.settleGroup(requestDTO);

        if(responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS))
        {
            List<jakarta.transaction.Transaction> transactions = responseDTO.getTransactions();
            for(Transaction t: transactions){
                System.out.println(t);
            }

        }
        else{
            System.out.println("Settle Group failed with message "+ responseDTO.getMessage());
        }
    }
}
