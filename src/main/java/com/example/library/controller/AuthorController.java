package com.example.library.controller;

import com.example.library.dto.AuthorBookInput;
import com.example.library.exception.AuthorAlreadyExistException;
import com.example.library.exception.AuthorNotFoundException;
import com.example.library.service.AuthorServiceImpl;
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
@RequestMapping("/author")
public class AuthorController {

    private final AuthorServiceImpl authorServiceImpl;

    public AuthorController(AuthorServiceImpl authorServiceImpl) {
        this.authorServiceImpl = authorServiceImpl;
    }

    @PostMapping("/new")
    public ResponseEntity addAuthor(@RequestBody AuthorBookInput input) {
        try {
            authorServiceImpl.addAuthor(input);
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
            return ResponseEntity.ok(authorServiceImpl.getOne(id));
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(authorServiceImpl.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
