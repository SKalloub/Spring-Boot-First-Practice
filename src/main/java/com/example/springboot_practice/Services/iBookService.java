package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Book;

import java.util.List;
import java.util.Optional;

public interface iBookService {
    public List<Book> getAllBooks();
    public Optional<Book> getBookById(int id);
    public Book addBook(Book b);

}
