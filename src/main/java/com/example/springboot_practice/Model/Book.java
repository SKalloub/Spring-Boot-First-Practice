package com.example.springboot_practice.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int isbn;
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "author")
    @JoinColumn(name = "authorId", nullable = false, referencedColumnName = "authorId")
    private Author author;
    @Column
    private boolean reserved;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference(value = "customer")
//    @JoinColumn(name = "customerID")
//    private Customer customer;

    public Book(int id, int isbn, String name) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
    }

    public Book(int isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }
}
