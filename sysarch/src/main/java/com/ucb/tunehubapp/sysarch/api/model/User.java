package com.ucb.tunehubapp.sysarch.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
    
    private int id;
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String email;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getId(){
        return id;
    }

    public User(int id, String name, int age, String email, String username, String password){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.username = username;
        this.password = password;
    }


}
