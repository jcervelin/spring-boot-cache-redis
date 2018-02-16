package com.example.exceptions;

public class PostNotFoundException extends Exception {

    public PostNotFoundException() {
        this("Not Found");
    }

    public PostNotFoundException(String message) {
        super(message);
    }
}
