package com.example.springboot_practice.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue
    private int id;
    private String name;
 //   private List<Book> bookList;
    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    //    bookList = new ArrayList<>();
    }
    public Author(String name) {
        this.name = name;
    }
}
