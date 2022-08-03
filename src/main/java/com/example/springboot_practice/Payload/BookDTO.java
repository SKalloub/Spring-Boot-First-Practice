package com.example.springboot_practice.Payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class BookDTO {
    private String name;
    private int isbn;
    private String authorName;
    private int authorID;

    public BookDTO (String name, int isbn, int authorID, String authorName) {
        this.name = name;
        this.isbn = isbn;
        this.authorID = authorID;
        this.authorName = authorName;
    }
    public BookDTO(String name, int isbn, int authorID) {
        this.name = name;
        this.isbn = isbn;
        this.authorID = authorID;
    }
    public BookDTO(String name, int isbn){
        this.name = name;
        this.isbn = isbn;
    }
}
