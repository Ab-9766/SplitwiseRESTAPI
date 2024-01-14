package org.example.splitwise_application_spring.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDTO {
    private String name;
    private String username;
    private String password;

}
