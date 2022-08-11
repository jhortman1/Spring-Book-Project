package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.dto.GenreDTO;
import com.flatiron.spring.SpringBookProject.model.Book;
import com.flatiron.spring.SpringBookProject.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/{id}/books")
    public List<BookDTO> getAllBooksInGenreById()
    {
        return  null;
    }
    @PostMapping
    public GenreDTO createGenre(@Valid @RequestBody GenreDTO genreDTO)
    {
        return null;
    }

}
