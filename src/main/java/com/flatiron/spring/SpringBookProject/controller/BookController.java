package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.dto.GetBookDTO;
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
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public GetBookDTO getBookById(@PathVariable int id)
    {
        return bookService.getBookById(id);
    }
    @PostMapping
    public GetBookDTO createBook(@Valid @RequestBody BookDTO bookDTO)
    {
        return bookService.create(bookDTO);
    }
    @PutMapping("/{id}")
    public GetBookDTO updateBook(@PathVariable int id, GetBookDTO getBookDTO)
    {
        return bookService.update(id,getBookDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable int id)
    {
        bookService.delete(id);
    }

}
