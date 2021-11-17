package com.example.library.model;

import com.example.library.entity.BookEntity;

public class Book {
    private int id;
    private String bookName;

    public Book() {
    }

    public static Book toModel(BookEntity bookEntity){
        Book modelBook = new Book();
        modelBook.setId(bookEntity.getId());
        modelBook.setBookName(bookEntity.getBookTitle());
        return modelBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


}
