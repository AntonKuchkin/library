package com.example.library.dto;

import com.example.library.entity.AuthorEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Author {
    private int id;
    private String name;

    public static Author toModel(AuthorEntity authorEntity) {
        Author modelAuthor = new Author();
        modelAuthor.setId(authorEntity.getId());
        modelAuthor.setName(authorEntity.getAuthorName());
        return modelAuthor;
    }

}
