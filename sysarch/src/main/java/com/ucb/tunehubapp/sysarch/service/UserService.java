package com.ucb.tunehubapp.sysarch.service;

import java.util.List;

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

    public String register(String username, String password) {
        // Check if username already exists
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            return "Message: Username already exists. Please choose another username.";
        }

        // Get the highest ID in the existing users
        List<User> allUsers = userRepository.findAll();
        int nextUserId = allUsers.stream()
                    .map(User::getId)
                    .mapToInt(Integer::parseInt)
                    .max()
                    .orElse(0) + 1;

        // Create a new User object with auto-incremented ID
        User newUser = new User(username, password, String.valueOf(nextUserId));

        // Save the user to MongoDB
        userRepository.save(newUser);

        return "Message: Registration Successful. User ID: " + newUser.getId();
    }
}