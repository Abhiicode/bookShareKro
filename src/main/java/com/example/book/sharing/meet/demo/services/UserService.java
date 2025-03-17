package com.example.book.sharing.meet.demo.services;

import com.example.book.sharing.meet.demo.entities.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
    User updateUserProfile(Long userId, User user);
    void verifyUser(String email, String otp);
}