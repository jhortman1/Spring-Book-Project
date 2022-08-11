package com.flatiron.spring.SpringBookProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name = "Book")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int pages;
    private Date published;
    @ManyToMany
    private List<ReadingList>readingLists=new ArrayList<>();
    @ManyToMany(mappedBy = "books")
    private  List<Genre>genres=new ArrayList<>();
    @ManyToOne
    private Author author;
}
