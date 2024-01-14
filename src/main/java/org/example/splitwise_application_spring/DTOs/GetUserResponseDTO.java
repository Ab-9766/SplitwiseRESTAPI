package org.example.splitwise_application_spring.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponseDTO {
    private String name;
    private String username; //Not returning password as it is sensitive info

    private ResponseStatus responseStatus;
    private String message;


}
