package org.example.splitwise_application_spring.Services;

import lombok.Getter;
import lombok.Setter;
import org.example.splitwise_application_spring.Models.Transaction;

import java.util.List;

public interface IUserSettleUpService {
    public List<Transaction> settleUpUser(Long userId);

}
