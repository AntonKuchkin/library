package com.example.library.exception;

public class AuthorAlreadyExistException extends Exception {
    public AuthorAlreadyExistException(String message) {
        super(message);
    }
}
