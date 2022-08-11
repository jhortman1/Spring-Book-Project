package com.flatiron.spring.SpringBookProject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GetBookDTO {
    private String title;
    private int pages;
    private Date published;

}