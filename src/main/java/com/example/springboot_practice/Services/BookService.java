package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Book;
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

    @Override
    public Optional<Book> getBookById(int id){

        return bookRepository.findById(id);
    }
    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    @Override
    public Book addBook(Book b) {
        return bookRepository.save(b);
    }
}
