package com.example.book.sharing.meet.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.sharing.meet.demo.entities.Book;
import com.example.book.sharing.meet.demo.entities.BorrowedBook;
import com.example.book.sharing.meet.demo.entities.User;
import com.example.book.sharing.meet.demo.repositories.BookRepository;
import com.example.book.sharing.meet.demo.repositories.BorrowedBookRepository;
import com.example.book.sharing.meet.demo.repositories.UserRepository;

import java.util.List;

@Service
public class BorrowedBookServiceImpl implements BorrowedBookService {

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BorrowedBook addBorrowedBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);
        if (user != null && book != null) {
            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBook.setUser(user);
            borrowedBook.setBook(book);
            borrowedBook.setBorrowed(false);
            return borrowedBookRepository.save(borrowedBook);
        }
        return null;
    }

    @Override
    public void markAsBorrowed(Long borrowedBookId, Long borrowedByUserId) {
        BorrowedBook borrowedBook = borrowedBookRepository.findById(borrowedBookId).orElse(null);
        User borrowedByUser = userRepository.findById(borrowedByUserId).orElse(null);
        if (borrowedBook != null && borrowedByUser != null) {
            borrowedBook.setBorrowed(true);
            borrowedBook.setUser(borrowedByUser);
            borrowedBookRepository.save(borrowedBook);
        }
    }

    @Override
    public void removeBorrowedBook(Long borrowedBookId) {
        borrowedBookRepository.deleteById(borrowedBookId);
    }

    @Override
    public List<BorrowedBook> getBorrowedBooksByUserId(Long userId) {
        return borrowedBookRepository.findByUserId(userId);
    }
}

