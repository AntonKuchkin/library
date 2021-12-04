package com.example.library.service;

import com.example.library.dto.Author;
import com.example.library.dto.AuthorBookInput;
import com.example.library.exception.AuthorAlreadyExistException;
import com.example.library.exception.AuthorNotFoundException;

public interface AuthorService {
    public Author addAuthor(AuthorBookInput input) throws AuthorAlreadyExistException;
    public Author getOne(Integer id) throws AuthorNotFoundException;
    public Integer delete(Integer id);
}
