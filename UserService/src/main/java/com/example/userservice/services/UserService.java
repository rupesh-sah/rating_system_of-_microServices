package com.example.userservice.services;

import com.example.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
//    create
    User saveUser(User user);

//    get all user
    List<User> getAllUser();

//    get a single user of given userId
    User getUser(String userId);
}
