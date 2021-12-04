package com.example.library.controller;

import com.example.library.dto.BookAuthorInput;
import com.example.library.exception.BookAlreadyExistException;
import com.example.library.exception.BookNotFoundException;
import com.example.library.service.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping("/new")
    public ResponseEntity addBook(@RequestBody BookAuthorInput input) {
        try {
            bookServiceImpl.addBook(input);
            return ResponseEntity.ok("Книга успешно создана");
        } catch (BookAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error, книга не создана");
        }
    }

    @GetMapping
    public ResponseEntity getOneBook(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(bookServiceImpl.getOne(id));
        } catch (BookNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(bookServiceImpl.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
