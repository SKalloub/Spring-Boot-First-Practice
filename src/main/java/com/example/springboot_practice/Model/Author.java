package com.example.springboot_practice.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Author {
    private int id;
    private String name;
    private List<Book> bookList;
    public Author(int id, String name) {
        this.id = id;
        this.name = name;
        bookList = new ArrayList<>();
    }
    public Author(String name) {
        this.name = name;
    }
}
