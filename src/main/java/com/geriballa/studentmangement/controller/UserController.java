package com.geriballa.studentmangement.controller;
import com.geriballa.studentmangement.controller.request.FindUserRequest;
import com.geriballa.studentmangement.model.User;
import com.geriballa.studentmangement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/test")
    public String test() {
        return "test success";
    }

    @PostMapping(value = "/find", produces = "application/json")
    public User findUser(@RequestBody FindUserRequest request) {
        User foundUser = userService.findUser(request.getLastName(), request.getPassword());
        return foundUser;
    }

    @PostMapping(value = "/create", produces = "application/json")
    public User createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return createdUser;
    }

}
