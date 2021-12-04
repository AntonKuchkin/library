package com.example.library.dto;

import com.example.library.entity.BookEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private int id;
    private String bookName;

    public static Book toModel(BookEntity bookEntity) {
        Book modelBook = new Book();
        modelBook.setId(bookEntity.getId());
        modelBook.setBookName(bookEntity.getBookTitle());
        return modelBook;
    }

}
