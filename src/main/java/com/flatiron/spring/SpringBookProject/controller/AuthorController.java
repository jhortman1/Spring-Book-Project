package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.AuthorDTO;
import com.flatiron.spring.SpringBookProject.model.Author;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("api/author")
public class AuthorController {
    @GetMapping
    public Set<Author> getAllAuthors()
    {
        return null;
    }
    @PostMapping
    public AuthorDTO createAuthor(@Valid @RequestBody AuthorDTO authorDTO)
    {
        return null;
    }
}
