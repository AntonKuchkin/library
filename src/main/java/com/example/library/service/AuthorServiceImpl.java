package com.example.library.service;

import com.example.library.dto.Author;
import com.example.library.dto.AuthorBookInput;
import com.example.library.entity.AuthorEntity;
import com.example.library.entity.BookEntity;
import com.example.library.exception.AuthorAlreadyExistException;
import com.example.library.exception.AuthorNotFoundException;
import com.example.library.repository.RepoAuthor;
import com.example.library.repository.RepoBook;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final RepoAuthor repoAuthor;
    private final RepoBook repoBook;

    public AuthorServiceImpl(RepoAuthor repoAuthor, RepoBook repoBook) {
        this.repoAuthor = repoAuthor;
        this.repoBook = repoBook;
    }

    public Author addAuthor(AuthorBookInput input) throws AuthorAlreadyExistException {
        BookEntity book = repoBook.findByBookTitle(input.getBookTitle());
        if (book == null) {
            book = new BookEntity();
            book.setBookTitle(input.getBookTitle());
            repoBook.save(book);
        }
        AuthorEntity author = repoAuthor.findByAuthorName(input.getAuthorName());
        if (author == null) {
            author = new AuthorEntity();
            author.setAuthorName(input.getAuthorName());
        }
        author.addBookToAuthor(book);
        repoAuthor.save(author);
        return Author.toModel(author);
    }

    public Author getOne(Integer id) throws AuthorNotFoundException {
        AuthorEntity author = repoAuthor.findById(id).get();
        if (author == null) {
            throw new AuthorNotFoundException("Автор не найден");
        }
        return Author.toModel(author);
    }

    public Integer delete(Integer id) {
        repoAuthor.deleteById(id);
        return id;
    }


}
