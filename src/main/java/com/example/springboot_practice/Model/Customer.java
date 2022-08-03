package com.example.springboot_practice.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    @Column
    private String name;
//    @JsonManagedReference(value = "customer")
//    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
//    private List<Book> books;

    public Customer(int id, String name){
        this.customerID = id;
        this.name = name;
       // books = new ArrayList<>();
    }
}
