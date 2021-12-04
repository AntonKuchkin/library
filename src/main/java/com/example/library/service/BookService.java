package com.example.library.service;

import com.example.library.dto.Book;
import com.example.library.dto.BookAuthorInput;
import com.example.library.exception.BookAlreadyExistException;
import com.example.library.exception.BookNotFoundException;

public interface BookService {
    public Book addBook (BookAuthorInput input) throws BookAlreadyExistException;
    public Book getOne (Integer id) throws BookNotFoundException;
    public Integer delete (Integer id);
}
