package com.example.book.sharing.meet.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.sharing.meet.demo.entities.Favourite;

public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
     List<Favourite> findByUserId(Long userId);
}