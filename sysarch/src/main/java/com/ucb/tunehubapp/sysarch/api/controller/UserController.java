package com.ucb.tunehubapp.sysarch.api.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucb.tunehubapp.sysarch.api.model.User;
import com.ucb.tunehubapp.sysarch.repository.UserRepository;
import com.ucb.tunehubapp.sysarch.service.UserService;

import springfox.documentation.annotations.ApiIgnore;


@CrossOrigin(origins = "*")
@RestController
public class UserController {
    
        @Autowired
        private UserService userService;
        
        @Autowired
        UserRepository repo;

        @ApiIgnore
        @RequestMapping(value="/")
        public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
        }
    
        @GetMapping("/getAllUsers")
        public List<User> getAllUsers() {
            try {
                return repo.findAll();
            } catch (Exception e) {
                // Log the exception for debugging
                e.printStackTrace(); // or use a logging framework like SLF4J
        
                // Optionally, you can throw a custom exception or return an error response
                throw new RuntimeException("Failed to fetch all users from database.");
            }
        }
    
        @PostMapping("/register")
        public String register(@RequestBody UserRegistrationRequest request) {
            String username = request.getUsername();
            String password = request.getPassword();
            return userService.register(username, password);
        }
    
        @PostMapping("/login")
        public String login(@RequestBody UserLoginRequest request) {
            String username = request.getUsername();
            String password = request.getPassword();
    
        
            return userService.login(username, password);
        }
    
        static class UserRegistrationRequest {
            private String username;
            private String password;
    
            // Getters and setters
            public String getUsername() {
                return username;
            }
    
            public void setUsername(String username) {
                this.username = username;
            }
    
            public String getPassword() {
                return password;
            }
    
            public void setPassword(String password) {
                this.password = password;
            }

        }
    
        static class UserLoginRequest {
            private String username;
            private String password;
    
            // Getters and setters
            public String getUsername() {
                return username;
            }
    
            public void setUsername(String username) {
                this.username = username;
            }
    
            public String getPassword() {
                return password;
            }
    
            public void setPassword(String password) {
                this.password = password;
            }
        }
    }