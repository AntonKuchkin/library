package com.example.library.service;

import com.example.library.dto.BookAuthorInput;
import com.example.library.entity.AuthorEntity;
import com.example.library.entity.BookEntity;
import com.example.library.exception.BookAlreadyExistException;
import com.example.library.exception.BookNotFoundException;
import com.example.library.model.Book;
import com.example.library.repository.RepoAuthor;
import com.example.library.repository.RepoBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookService {
    @Autowired
    private RepoBook repoBook;
    @Autowired
    private RepoAuthor repoAuthor;

    public BookEntity addBook (BookAuthorInput input) throws BookAlreadyExistException{

        AuthorEntity author = repoAuthor.findByAuthorName(input.getAuthorName());

        if (author == null) {
            author = new AuthorEntity();
            author.setAuthorName(input.getAuthorName());
            repoAuthor.save(author);
        }

        BookEntity book = repoBook.findByBookTitle(input.getBookTitle());

        if (book == null){
           book = new BookEntity();
           book.setBookTitle(input.getBookTitle());

        }
        book.addAuthorToBook(author);
        return repoBook.save(book);
    }

    public Book getOne (Integer id) throws BookNotFoundException {
        BookEntity book = repoBook.findById(id).get();
        if (book == null){
            throw new BookNotFoundException("Книга не найдена");
        }
        return Book.toModel(book);
    }
    public Integer delete (Integer id){
        repoBook.deleteById(id);
        return id;
    }

}
