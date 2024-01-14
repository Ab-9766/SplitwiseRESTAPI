package org.example.splitwise_application_spring;

import org.example.splitwise_application_spring.Commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplicationSpringApplication implements CommandLineRunner {
    private CommandRegistry commandRegistry;

    @Autowired
    public SplitwiseApplicationSpringApplication(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplicationSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scn = new Scanner(System.in);
        while (true) {
            String input = scn.nextLine();
            if (input.equals("Quit")) {
                break;
            } else {
                commandRegistry.process(input);
            }
        }
    }

    //1.createUser(name, username, password)
    //2.getUser( userId)
    //3.settleGroup(groupName)



}
