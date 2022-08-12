package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.AuthorDTO;
import com.flatiron.spring.SpringBookProject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @GetMapping
    public List<AuthorDTO> getAllAuthors()
    {
        return authorService.getAll();
    }
}
