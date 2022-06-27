//package com.example.springboot_practice.Repositories;
//
//import com.example.springboot_practice.Model.Author;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AuthorRepositoryUnused {
//    private static AuthorRepositoryUnused authorRepository;
//    private List<Author> authorList;
//    private AuthorRepositoryUnused(){
//        authorList = new ArrayList<>();
//    }
//
//    public static AuthorRepositoryUnused getRepository(){
//        if (authorRepository==null)
//            authorRepository = new AuthorRepositoryUnused();
//
//        return authorRepository;
//    }
//
//    public List<Author> getAllAuthors() {
//        return authorList;
//    }
//    public Author getAuthorById(int id) {
//        return authorList.stream().filter(author -> author.getId() == id)
//                .findAny()
//                .orElse(null);
//    }
//    public boolean addAuthor(String name) {
//        return authorList.add(new Author(authorList.size()+1,name));
//    }
//}
