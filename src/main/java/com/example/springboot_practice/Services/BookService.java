package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Model.Customer;
import com.example.springboot_practice.Repositories.BookRepository;
import com.example.springboot_practice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private CustomerRepository customerRepository;
    private BookRepository bookRepository;
    @Autowired
    public BookService() {
        this.customerRepository = CustomerRepository.getRepository();
        this.bookRepository = BookRepository.getRepository();
    }
    public boolean reserveBook(int customerId, int BookId) {
        CustomerRepository customerRepository = CustomerRepository.getRepository();
        Customer c = customerRepository.getCustomerById(customerId);
        if (c==null)
            return false;

        Book b = bookRepository.getBookById(BookId);

        if (b==null)
            return false;

        if (b.isReserved())
            return false;

        c.getBooks().add(b);
        b.setCustomer(c);
        b.setReserved(true);
        return true;
    }
    public boolean returnBook(int customerId, int BookId) {
        CustomerRepository customerRepository = CustomerRepository.getRepository();
        Customer c = customerRepository.getCustomerById(customerId);
        if (c==null)
            return false;

        Book b = bookRepository.getBookById(BookId);

        if (b==null)
            return false;

        if (!b.isReserved())
            return false;

        if (c.getId()!=customerId)
            return false;

        b.setCustomer(null);
        c.getBooks().remove(b);
        b.setReserved(false);
        return true;
    }

    public Book getBookById(int id){
        return bookRepository.getBookById(id);
    }
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
    public boolean addBook(int isbn, String name, int authorID) {
        return bookRepository.addBook(isbn,name,authorID);
    }
}
