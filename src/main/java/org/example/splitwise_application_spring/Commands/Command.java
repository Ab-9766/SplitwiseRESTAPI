package org.example.splitwise_application_spring.Commands;

public interface Command {
    boolean canExecute(String input);
    void Execute(String input);

}

