package com.example.springboot_practice.Services;

import com.example.springboot_practice.Exceptions.ResourceNotFoundException;
import com.example.springboot_practice.Model.Author;
import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Payload.BookDTO;
import com.example.springboot_practice.Repositories.AuthorRepository;
import com.example.springboot_practice.Repositories.BookRepository;
import com.example.springboot_practice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements iBookService{

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Optional<Book> getBookById(int id){

        return bookRepository.findById(id);
    }
    @Override
    public List<Book> getAllBooks(){
        System.err.println("Get All Books");
        return bookRepository.findAll();
    }
    @Override
    public Book addBook(BookDTO b, int authorID) {
        Author author = authorRepository.findById(authorID).orElse(null);
        Book book = new Book(b.getIsbn(),b.getName());
        book.setAuthor(author);
        System.err.println(book.getId());
        return bookRepository.save(book);
    }

//    @Override
//    public Book reserveBook(int bid, int cid) {
//        Book book = bookRepository.findById(bid).orElse( null);
//       Customer customer = customerRepository.findById(cid).orElse(null);
//       book.setCustomer(customer);
//       bookRepository.save(book);
//       customerRepository.save(customer);
//       return book;
//    }
    @Override
    public Book deleteBook(int bid) {
        Book toBeDeleted = bookRepository.findById(bid).orElseThrow(() -> new ResourceNotFoundException());
        bookRepository.delete(toBeDeleted);
        return toBeDeleted;
    }

}
