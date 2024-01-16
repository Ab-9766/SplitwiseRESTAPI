package org.example.splitwise_application_spring.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "user")
public class User extends BaseModel{
    private String name;
    private String userName;
    private String password;


}
