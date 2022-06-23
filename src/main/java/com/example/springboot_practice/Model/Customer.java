package com.example.springboot_practice.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name){
        this.id = id;
        this.name = name;
        books = new ArrayList<>();
    }
    private List<Book> books;
}
