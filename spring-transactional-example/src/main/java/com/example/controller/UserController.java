package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JmsTemplate jmsTemplate;


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<User> getUser() {
        return userService.getUser();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
       // jmsTemplate.convertAndSend("userQueue",user);
        userService.createUser(user);
    }
}
