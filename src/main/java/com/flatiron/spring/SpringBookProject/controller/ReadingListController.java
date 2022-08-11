package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.ReadingListDTO;
import com.flatiron.spring.SpringBookProject.model.ReadingList;
import com.flatiron.spring.SpringBookProject.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/api/reading_lists")
public class ReadingListController {
    @Autowired
    private ReadingListRepository readingListRepository;

    @GetMapping
    public Set<ReadingList> getAllReadingList()
    {
        return null;
    }
    @PostMapping
    public ReadingListDTO createReadingList(@Valid @RequestBody ReadingListDTO readingListDTO)
    {
        return  null;
    }
}
