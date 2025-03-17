package com.example.book.sharing.meet.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.sharing.meet.demo.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}