package com.flatiron.spring.SpringBookProject.dto;

import com.flatiron.spring.SpringBookProject.model.Author;
import com.flatiron.spring.SpringBookProject.model.Genre;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class GetBookDTO {
    private int id;
    private String title;
    private int pages;
    private LocalDate published;
}
