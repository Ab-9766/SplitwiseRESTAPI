package org.example.splitwise_application_spring.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CommandRegistry {
    List<Command> commands= new ArrayList<>();

    @Autowired
    public CommandRegistry(CreateUserCommand createUserCommand, GetUserCommand getUserCommand,
                           SettleGroupCommand settleGroupCommand) {
        this.commands.add(createUserCommand);
        this.commands.add(getUserCommand);
        this.commands.add(settleGroupCommand);
    }
    public void process(String input){
        for(Command command: commands){
            if(command.canExecute(input)== true){
                command.Execute(input);
                break;
            }

        }
    }
}
