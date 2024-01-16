package org.example.splitwise_application_spring.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Group extends BaseModel {
    @ManyToMany
    private List<User> users; //Relationship as participant

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;

    @ManyToOne
     private User createdBy; //Relationship as Admin

}
