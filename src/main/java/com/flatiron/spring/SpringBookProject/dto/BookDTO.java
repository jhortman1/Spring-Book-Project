package com.flatiron.spring.SpringBookProject.dto;

import com.flatiron.spring.SpringBookProject.model.Author;
import com.flatiron.spring.SpringBookProject.model.Genre;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
 public class  BookDTO {
    private String title;
    private int pages;
    private LocalDate published;
    private String authorName;
    private String genreDTO;

}
