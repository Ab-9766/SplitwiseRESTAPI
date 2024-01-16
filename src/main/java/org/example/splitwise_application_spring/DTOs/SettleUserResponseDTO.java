package org.example.splitwise_application_spring.DTOs;

import jakarta.transaction.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUserResponseDTO {
    private List<Transaction> transactions;

    private ResponseStatus responseStatus;
    private String message;

}
