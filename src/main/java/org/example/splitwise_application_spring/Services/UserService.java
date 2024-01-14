package org.example.splitwise_application_spring.Services;

import org.example.splitwise_application_spring.Models.User;
import org.example.splitwise_application_spring.Repositories.UserRepository;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(String name, String username, String password){
        User user= new User();
        user.setName(name);
        user.setUserName(username);
        user.setPassword(password);
        User savedUser=userRepository.save(user);
        return savedUser;
    }
    public User getUser(Long userId) throws Exception{
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new Exception("User not found");
        }
        else{
            return userOptional.get();
        }
    }
}
