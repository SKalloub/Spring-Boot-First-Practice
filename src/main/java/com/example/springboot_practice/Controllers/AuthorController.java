package com.example.springboot_practice.Controllers;

import com.example.springboot_practice.Model.Author;
import com.example.springboot_practice.Services.iAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/authors")
@RestController
public class AuthorController {
    @Autowired
    private  iAuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable(name="id") int id) {
        return authorService.getAuthorById(id);
    }
    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author author1 = authorService.addAuthor(author);
        if (author1!=null)
            return new ResponseEntity<>(author1, HttpStatus.OK);
        else
            return new ResponseEntity<>(author1, HttpStatus.BAD_REQUEST);
    }
}
