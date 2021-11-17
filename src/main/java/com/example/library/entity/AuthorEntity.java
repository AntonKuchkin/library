package com.example.library.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "author")
    private String authorName;
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id") , inverseJoinColumns = @JoinColumn(name = "book_id"))

    private List<BookEntity>bookEntityList;

    public AuthorEntity() {
    }

    public AuthorEntity(String authorName) {
        this.authorName = authorName;
    }

    public AuthorEntity(Integer id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<BookEntity> getBookEntityList() {
        return bookEntityList;
    }

    public void setBookEntityList(List<BookEntity> bookEntityList) {
        this.bookEntityList = bookEntityList;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    public void addBookToAuthor(BookEntity book){
        if (bookEntityList==null){
            bookEntityList = new ArrayList<>();
        }
        bookEntityList.add(book);
    }
}
