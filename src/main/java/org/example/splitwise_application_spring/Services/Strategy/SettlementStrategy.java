package org.example.splitwise_application_spring.Services.Strategy;



import org.example.splitwise_application_spring.Models.Transaction;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface SettlementStrategy {
    List<Transaction> settleUp(HashMap<String,Integer> balanceSheet);
}
