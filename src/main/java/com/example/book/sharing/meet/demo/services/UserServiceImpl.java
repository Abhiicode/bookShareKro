package com.example.book.sharing.meet.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.sharing.meet.demo.entities.User;
import com.example.book.sharing.meet.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Generate OTP and set it to the user
        user.setOtp("123456"); // In real-world, generate a random OTP
        user.setVerified(false);
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
    
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public User updateUserProfile(Long userId, User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void verifyUser(String email, String otp) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getOtp().equals(otp)) {
            user.setVerified(true);
            userRepository.save(user);
        }
    }
}