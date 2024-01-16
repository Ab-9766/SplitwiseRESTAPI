package org.example.splitwise_application_spring.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.splitwise_application_spring.Models.Enums.ExpenseType;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private int amount;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "expense")
    List<ExpenseUser> expenseUser;



}
