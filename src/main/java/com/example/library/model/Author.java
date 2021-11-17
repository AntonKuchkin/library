package com.example.library.model;

import com.example.library.entity.AuthorEntity;

public class Author {
    private int id;
    private String name;

    public Author() {
    }

    public static Author toModel(AuthorEntity authorEntity){
        Author modelAuthor = new Author();
        modelAuthor.setId(authorEntity.getId());
        modelAuthor.setName(authorEntity.getAuthorName());
        return modelAuthor;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
