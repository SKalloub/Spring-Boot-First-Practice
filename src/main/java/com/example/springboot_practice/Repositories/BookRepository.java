package com.example.springboot_practice.Repositories;

import com.example.springboot_practice.Model.Author;
import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BookRepository {
    private static BookRepository bookRepository;

    private List<Book> bookList;

    private BookRepository(){
        bookList = new ArrayList<>();
    }

    public static BookRepository getRepository(){
        if (bookRepository==null)
            bookRepository = new BookRepository();

        return bookRepository;
    }
    public List<Book> getAllBooks() {
        return bookList;
    }
    public Book getBookById(int id){
        return bookList.stream().filter(book -> book.getId() == id)
                .findAny()
                .orElse(null);
    }
    public boolean addBook(int isbn, String name, int authorID){
        Author author = AuthorRepository.getRepository().getAuthorById(authorID);
        if (author==null)
            return false;
        Book b = new Book(bookList.size()+1,isbn,name,author);
        author.getBookList().add(b);
        return bookList.add(b);
    }

}
