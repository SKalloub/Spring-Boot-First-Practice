package com.example.springboot_practice.Controllers;

import com.example.springboot_practice.Model.Author;
import com.example.springboot_practice.Model.Book;
import com.example.springboot_practice.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/authors")
@RestController
public class AuthorController {
    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable(name="id") int id) {
        return authorService.getAuthorById(id);
    }
    @PostMapping
    public ResponseEntity<Boolean> addAuthor(@RequestBody Author author) {
        boolean status = authorService.addAuthor(author.getName());
        if (status)
            return new ResponseEntity<>(status, HttpStatus.OK);
        else
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
    }
}
