package com.example.book.sharing.meet.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    
    @GetMapping("/")
    public String getMethodName() {
        return "index"; // Refers to templates/index.html
    }
}
