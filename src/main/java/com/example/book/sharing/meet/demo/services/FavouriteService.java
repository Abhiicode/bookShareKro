package com.example.book.sharing.meet.demo.services;

import java.util.List;

import com.example.book.sharing.meet.demo.entities.Favourite;

public interface FavouriteService{
    Favourite addFavourite(Long userId, Long bookId);
    void removeFavourite(Long favouriteId);
    List<Favourite> getFavouritesByUserId(Long userId);
}