package com.example.springboot_practice.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    private int id;
    @Column
    private int isbn;
    @Column
    private String name;
    //private Author author;
    @Column
    private boolean reserved;
  //  private Customer customer;

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
