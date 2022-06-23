package com.example.springboot_practice.Controllers;

import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/books")
@RestController
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(name="id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/{authorID}/books")
    public ResponseEntity<Boolean> addBook(@RequestBody Book book, @PathVariable(name="authorID") int authorID) {
        boolean status = bookService.addBook(book.getIsbn(), book.getName(), authorID);
        if (status)
            return new ResponseEntity<>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
    }

}
