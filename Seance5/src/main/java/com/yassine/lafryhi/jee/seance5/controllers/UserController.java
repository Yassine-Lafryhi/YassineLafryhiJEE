package com.yassine.lafryhi.jee.seance5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.lafryhi.jee.seance5.entities.User;
import com.yassine.lafryhi.jee.seance5.services.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}")
    public User user(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }
}
