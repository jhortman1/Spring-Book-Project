package com.flatiron.spring.SpringBookProject.controller;
import com.flatiron.spring.SpringBookProject.dto.GetBookDTO;
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
    public List<GetBookDTO> getAllBooksInGenreById(@PathVariable int id)
    {
        return  genreService.getAllBooksInGenreById(id);
    }
}
