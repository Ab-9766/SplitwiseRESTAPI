package org.example.splitwise_application_spring.Services;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.example.splitwise_application_spring.Models.Expense;
import org.example.splitwise_application_spring.Models.ExpenseUser;
import org.example.splitwise_application_spring.Models.Transaction;
import org.example.splitwise_application_spring.Models.User;
import org.example.splitwise_application_spring.Repositories.ExpenseRepository;
import org.example.splitwise_application_spring.Repositories.ExpenseUserRepository;
import org.example.splitwise_application_spring.Repositories.UserRepository;
import org.example.splitwise_application_spring.Services.Strategy.SettlementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserSettleUpService implements IUserSettleUpService {

    private ExpenseUserRepository expenseUserRepository;
    private UserRepository userRepository;
    private SettlementStrategy settlementStrategy;


    @Autowired
    public UserSettleUpService(ExpenseUserRepository expenseUserRepository, UserRepository userRepository,
                               SettlementStrategy settlementStrategy) {
        this.expenseUserRepository = expenseUserRepository;
        this.userRepository = userRepository;
        this.settlementStrategy = settlementStrategy;
    }

    @Override
    public List<Transaction> settleUpUser(Long userId) throws Exception {
        /*
         * S1. Get all the expenses for that particular user.
         * S2. Iterate and find who paid extra and less
         * S3. Take the heap approach
         * S4. Just return transaction objects where userId is involved.
         */
        Optional<User> user= userRepository.findById(userId);
        if(user.isEmpty()){
            throw new Exception();
        }
        List<ExpenseUser> expenseUsers= expenseUserRepository.findAllByUser(user.get());
        return null;
        //Logic to be added
    }
}
