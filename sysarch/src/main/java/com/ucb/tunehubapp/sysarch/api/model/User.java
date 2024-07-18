package com.ucb.tunehubapp.sysarch.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

//For all users username and password only
@Document(collection = "Users")
public class User {
    
    private String id;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    

    public User(String username, String password, String id){
        this.username = username;
        this.password = password;
        this.id = id;
    }


}
