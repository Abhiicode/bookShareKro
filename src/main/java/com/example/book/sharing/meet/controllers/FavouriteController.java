package com.example.book.sharing.meet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.sharing.meet.demo.entities.Favourite;
import com.example.book.sharing.meet.demo.services.FavouriteService;

@RestController
@RequestMapping("/favourites")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @PostMapping("/add")
    public Favourite addFavourite(@RequestParam Long userId, @RequestParam Long bookId) {
        return favouriteService.addFavourite(userId, bookId);
    }

    @DeleteMapping("/remove/{favouriteId}")
    public void removeFavourite(@PathVariable Long favouriteId) {
        favouriteService.removeFavourite(favouriteId);
    }

    @GetMapping("/user/{userId}")
    public List<Favourite> getFavouritesByUserId(@PathVariable Long userId) {
        return favouriteService.getFavouritesByUserId(userId);
    }
}