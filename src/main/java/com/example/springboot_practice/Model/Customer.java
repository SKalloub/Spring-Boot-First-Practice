package com.example.springboot_practice.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private int id;
    @Column
    private String name;

    public Customer(int id, String name){
        this.id = id;
        this.name = name;
       // books = new ArrayList<>();
    }
 //   private List<Book> books;
}
