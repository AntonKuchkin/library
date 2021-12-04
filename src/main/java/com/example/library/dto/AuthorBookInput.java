package com.example.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorBookInput {

    String authorName;
    String bookTitle;

}
