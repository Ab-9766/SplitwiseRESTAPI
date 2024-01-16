package org.example.splitwise_application_spring.Repositories;

import org.example.splitwise_application_spring.Models.ExpenseUser;
import org.example.splitwise_application_spring.Models.Transaction;
import org.example.splitwise_application_spring.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(User user);
}
