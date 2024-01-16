package org.example.splitwise_application_spring.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.splitwise_application_spring.Models.Enums.ExpenseUserType;

@Getter
@Setter
@Entity
public class ExpenseUser extends BaseModel{

    @ManyToOne
    private Expense expense;

    @ManyToOne
     private User user; //EU:U

     private int amount;

     @Enumerated(EnumType.ORDINAL)
     private ExpenseUserType expenseUserType;



}
