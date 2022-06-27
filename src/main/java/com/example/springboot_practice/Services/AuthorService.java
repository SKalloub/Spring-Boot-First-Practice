package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Author;
import com.example.springboot_practice.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements iAuthorService{
    @Autowired
    public AuthorRepository authorRepository;
    @Override
    public Author addAuthor(Author author) {
        Author authorFound = authorRepository.save(author);
        return authorFound;
    }
    public List<Author> getAllAuthors() {
    return authorRepository.findAll();
    }
    public Optional<Author> getAuthorById(int id) {
    return authorRepository.findById(id);
    }
}
