package com.example.springboot_practice.Controllers;

import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Payload.BookDTO;
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
        List<Book> books = bookService.getAllBooks();
        System.err.println(books.size());
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable(name="id") int id) {
            return bookService.getBookById(id);
    }
    @PostMapping("/authors/{authorid}")
    public ResponseEntity<Book> addBook(@RequestBody BookDTO book, @PathVariable(name = "authorid") int aid) {
        System.err.println(book.toString());
        Book book1 = bookService.addBook(book, aid);
        if (book1!=null)
            return new ResponseEntity<>(book1, HttpStatus.OK);
        else
            return new ResponseEntity<>(book1, HttpStatus.BAD_REQUEST);
    }
//    @PostMapping("/{bookID}/{customerID}")
//    public ResponseEntity<Book> reserveBook(@PathVariable(name="bookID") int bookID, @PathVariable(name = "customerID") int customerID) {
//        Book b = bookService.reserveBook(bookID,customerID);
//        if (b!=null)
//            return new ResponseEntity<>(b, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(b, HttpStatus.BAD_REQUEST);
//    }
    @DeleteMapping("/{bookID}")
    public ResponseEntity<Book> deleteBook(@PathVariable(name = "bookID") int id) {
       Book b =  bookService.deleteBook(id);
       return new ResponseEntity<>(b,b==null ? HttpStatus.NOT_FOUND : HttpStatus.OK);

    }
//    @DeleteMapping("/{bookID}/{customerID}")
//    public ResponseEntity<Boolean> returnBook(@PathVariable(name = "bookID") int bookID, @PathVariable(name = "customerID") int customerID) {
//        boolean status = bookService.returnBook(customerID,bookID);
//        if (status)
//            return new ResponseEntity<>(status, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
//    }

}
