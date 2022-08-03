package com.example.springboot_practice.Repositories;

import com.example.springboot_practice.Model.Author;
import com.example.springboot_practice.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
List<Book> findBooksByAuthor(Author author);
}
