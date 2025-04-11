package com.example.book.sharing.meet.demo.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class TestDTO {
    @NotBlank(message = "input string is required")
    @JsonProperty("input") 
    public String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
