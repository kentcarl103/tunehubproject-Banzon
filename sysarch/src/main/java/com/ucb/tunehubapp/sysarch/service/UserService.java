package com.ucb.tunehubapp.sysarch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucb.tunehubapp.sysarch.api.model.User;
import com.ucb.tunehubapp.sysarch.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String login(String username, String password) {
        // Checking if either username or password is null
        if (username == null || password == null) {
            return "Message: Either username or password is null";
        }

        // Checking if user exists in the database
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return "Message: Invalid Credentials";
        }

        // If everything is correct
        return "Message: Log in successfully";
    }
}
