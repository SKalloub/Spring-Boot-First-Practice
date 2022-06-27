package com.example.springboot_practice.Services;

import com.example.springboot_practice.Model.Author;

import java.util.List;
import java.util.Optional;

public interface iAuthorService {
    public Author addAuthor(Author author);
    public List<Author> getAllAuthors();
    public Optional<Author> getAuthorById(int id);

}
