package com.ucb.tunehubapp.sysarch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ucb.tunehubapp.sysarch.api.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
    
}
