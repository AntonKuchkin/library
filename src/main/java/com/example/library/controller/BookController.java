package com.example.library.controller;

import com.example.library.dto.BookAuthorInput;
import com.example.library.entity.AuthorEntity;
import com.example.library.entity.BookEntity;
import com.example.library.exception.BookAlreadyExistException;
import com.example.library.exception.BookNotFoundException;
import com.example.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/new")
    public ResponseEntity addBook (@RequestBody BookAuthorInput input){
        try{
            bookService.addBook(input);
            return ResponseEntity.ok("Книга успешно создана");
        } catch (BookAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error, книга не создана");
        }
    }
    @GetMapping
    public ResponseEntity getOneBook(@RequestParam Integer id){
        try{
            return ResponseEntity.ok(bookService.getOne(id));
        } catch (BookNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        try{
            return ResponseEntity.ok(bookService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
