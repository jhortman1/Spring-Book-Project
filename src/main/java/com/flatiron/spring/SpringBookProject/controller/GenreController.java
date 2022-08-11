package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.model.Book;
import com.flatiron.spring.SpringBookProject.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
