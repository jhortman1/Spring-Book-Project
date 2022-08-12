package com.flatiron.spring.SpringBookProject.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetGenreDTO {
    private String name;
    private List<BookDTO>bookList;
}