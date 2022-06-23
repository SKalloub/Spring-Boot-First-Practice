package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Author;
import com.example.springboot_practice.Repositories.AuthorRepository;
import com.example.springboot_practice.Repositories.BookRepository;
import com.example.springboot_practice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
public AuthorRepository authorRepository;
@Autowired
    public AuthorService() {
        this.authorRepository = AuthorRepository.getRepository();
    }

    public boolean addAuthor(String name) {
   return authorRepository.addAuthor(name);
    }

    public List<Author> getAllAuthors() {
    return authorRepository.getAllAuthors();
    }
    public Author getAuthorById(int id) {
    return authorRepository.getAuthorById(id);
    }

}
