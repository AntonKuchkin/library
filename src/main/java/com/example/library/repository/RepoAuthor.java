package com.example.library.repository;

import com.example.library.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAuthor extends JpaRepository<AuthorEntity, Integer> {
        AuthorEntity findByAuthorName (String authorName);
}
