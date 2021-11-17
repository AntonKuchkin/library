package com.example.library.controller;

import com.example.library.dto.AuthorBookInput;
import com.example.library.entity.AuthorEntity;
import com.example.library.exception.AuthorAlreadyExistException;
import com.example.library.exception.AuthorNotFoundException;
import com.example.library.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/new")
    public ResponseEntity addAuthor(@RequestBody AuthorBookInput input) {
        try {
            authorService.addAuthor(input);
            return ResponseEntity.ok("Автор успешно создан");
        } catch (AuthorAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error, автор не создан");
        }

    }

    @GetMapping
    public ResponseEntity getOneAuthor(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(authorService.getOne(id));
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(authorService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
    //Привет

}
