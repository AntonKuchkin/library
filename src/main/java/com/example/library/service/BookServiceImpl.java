package com.example.library.service;

import com.example.library.dto.Book;
import com.example.library.dto.BookAuthorInput;
import com.example.library.entity.AuthorEntity;
import com.example.library.entity.BookEntity;
import com.example.library.exception.BookAlreadyExistException;
import com.example.library.exception.BookNotFoundException;
import com.example.library.repository.RepoAuthor;
import com.example.library.repository.RepoBook;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImpl implements BookService {
    private final RepoBook repoBook;
    private final RepoAuthor repoAuthor;

    public BookServiceImpl(RepoBook repoBook, RepoAuthor repoAuthor) {
        this.repoBook = repoBook;
        this.repoAuthor = repoAuthor;
    }

    public Book addBook (BookAuthorInput input) throws BookAlreadyExistException{

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
        repoBook.save(book);
        return Book.toModel(book);
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
