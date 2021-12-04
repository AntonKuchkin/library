package com.example.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "author")
@NoArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "author")
    private String authorName;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))

    private List<BookEntity> bookEntityList;

    public AuthorEntity(String authorName) {
        this.authorName = authorName;
    }

    public AuthorEntity(Integer id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public void addBookToAuthor(BookEntity book) {
        if (bookEntityList == null) {
            bookEntityList = new ArrayList<>();
        }
        bookEntityList.add(book);
    }
}
