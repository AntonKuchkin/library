package com.example.library.repository;

import com.example.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoBook extends JpaRepository <BookEntity, Integer>{
    BookEntity findByBookTitle (String bookTitle);
}
