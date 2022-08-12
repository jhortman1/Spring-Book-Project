package com.flatiron.spring.SpringBookProject.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateBookDTO {
    private String title;
    private int pages;
    private LocalDate published;
    private String authorName;
    private String genre;
}
