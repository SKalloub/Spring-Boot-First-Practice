package com.example.springboot_practice.Model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    @Column
    private String name;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> bookList;
    public Author(int id, String name) {
        this.authorId = id;
        this.name = name;
    //    bookList = new ArrayList<>();
    }
    public Author(String name) {
        this.name = name;
    }
}
