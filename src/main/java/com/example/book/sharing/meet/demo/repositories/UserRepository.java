package com.example.book.sharing.meet.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.sharing.meet.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}