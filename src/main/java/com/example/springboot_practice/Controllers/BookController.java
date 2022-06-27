package com.example.springboot_practice.Controllers;

import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Book> getBookById(@PathVariable(name="id") int id) {
            return bookService.getBookById(id);
    }

    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book book1 = bookService.addBook(book);
        if (book1!=null)
            return new ResponseEntity<>(book1, HttpStatus.OK);
        else
            return new ResponseEntity<>(book1, HttpStatus.BAD_REQUEST);
    }
//    @PostMapping("/{bookID}/{customerID}")
//    public ResponseEntity<Boolean> reserveBook(@PathVariable(name="bookID") int bookID, @PathVariable(name = "customerID") int customerID) {
//        boolean status = bookService.reserveBook(customerID,bookID);
//        if (status)
//            return new ResponseEntity<>(status, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
//    }
//    @DeleteMapping("/{bookID}/{customerID}")
//    public ResponseEntity<Boolean> returnBook(@PathVariable(name = "bookID") int bookID, @PathVariable(name = "customerID") int customerID) {
//        boolean status = bookService.returnBook(customerID,bookID);
//        if (status)
//            return new ResponseEntity<>(status, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
//    }

}
