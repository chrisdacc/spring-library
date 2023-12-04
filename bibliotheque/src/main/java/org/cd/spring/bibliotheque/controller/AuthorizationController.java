package org.cd.spring.bibliotheque.controller;

import org.cd.spring.bibliotheque.model.Book;
import org.cd.spring.bibliotheque.service.BookService;
import org.cd.spring.bibliotheque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> sayHello() {

        return new ResponseEntity<>("CONNECTED!!",HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findBook(Math.toIntExact(id));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}