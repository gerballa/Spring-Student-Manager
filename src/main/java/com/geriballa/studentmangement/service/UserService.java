package com.geriballa.studentmangement.service;

import com.geriballa.studentmangement.controller.request.FindUserRequest;
import com.geriballa.studentmangement.model.User;
import com.geriballa.studentmangement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User findUser(String lastName, String password) {
        return this.repository.findFirstByLastNameAndPassword(lastName, password);
    }

    public User createUser(User user) {
        User createdUser = this.repository.save(user);
        return createdUser;
    }

}
