package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.model.Book;
import com.flatiron.spring.SpringBookProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getAllBooks()
    {
        return null;
    }
    @GetMapping("/{id}")
    public BookDTO getBookById()
    {
        return null;
    }
    @PostMapping
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO)
    {
        return null;
    }
    @PutMapping("/{id}")
    public BookDTO updateBook(@Valid @RequestBody BookDTO bookDTO)
    {
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable int id)
    {

    }

}
