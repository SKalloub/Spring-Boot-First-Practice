package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Payload.BookDTO;

import java.util.List;
import java.util.Optional;

public interface iBookService {
    public List<Book> getAllBooks();
    public Optional<Book> getBookById(int id);
    public Book addBook(BookDTO b, int authorID);
//    public Book reserveBook(int bid, int cid);
    public Book deleteBook(int id);
}
