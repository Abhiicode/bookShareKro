package com.example.book.sharing.meet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.sharing.meet.demo.entities.User;
import com.example.book.sharing.meet.demo.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);
    }

    @PutMapping("/{userId}")
    public User updateUserProfile(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUserProfile(userId, user);
    }

    @PostMapping("/verify")
    public void verifyUser(@RequestParam String email, @RequestParam String otp) {
        userService.verifyUser(email, otp);
    }

    @GetMapping("/")
    public String entryPoint(@RequestParam String param) {
        return "Welcome to my book store";
    }
    
}