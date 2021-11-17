package com.example.library.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "book")
    private String bookTitle;
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id") , inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<AuthorEntity> authorEntityList;

    public BookEntity() {
    }

    public BookEntity(int id, String bookTitle) {
        this.id = id;
        this.bookTitle = bookTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public List<AuthorEntity> getAuthorEntityList() {
        return authorEntityList;
    }

    public void setAuthorEntityList(List<AuthorEntity> authorEntityList) {
        this.authorEntityList = authorEntityList;
    }

    @Override
    public String toString() {
        return "bookEntity{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }

    public void addAuthorToBook(AuthorEntity author) {
        if (authorEntityList == null){
            authorEntityList = new ArrayList<>();
        }
        authorEntityList.add(author);

    }
}

