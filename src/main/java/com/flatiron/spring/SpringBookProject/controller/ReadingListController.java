package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.ReadingListDTO;
import com.flatiron.spring.SpringBookProject.service.ReadinglistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/reading_lists")
public class ReadingListController {

    @Autowired
    ReadinglistService readinglistService;

    @GetMapping("api/reading_list")
    public List<ReadingListDTO> getAllReadingList()
    {
        return readinglistService.getAll();
    }
}
