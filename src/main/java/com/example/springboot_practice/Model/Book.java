package com.example.springboot_practice.Model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Book {
    private int id;
    private int isbn;
    private String name;
    private Author author;
    private boolean reserved;
    private Customer customer;

    public Book(int id, int isbn, String name, Author author) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
    }

    public Book(int isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }
}
