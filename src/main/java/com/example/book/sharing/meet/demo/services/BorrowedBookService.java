package com.example.book.sharing.meet.demo.services;
import java.util.List;

import com.example.book.sharing.meet.demo.entities.BorrowedBook;

public interface BorrowedBookService {
    BorrowedBook addBorrowedBook(Long userId, Long bookId);
    void markAsBorrowed(Long borrowedBookId, Long borrowedByUserId);
    void removeBorrowedBook(Long borrowedBookId);
    List<BorrowedBook> getBorrowedBooksByUserId(Long userId);
}
