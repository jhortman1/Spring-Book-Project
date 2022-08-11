package com.flatiron.spring.SpringBookProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

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
    private Set<ReadingList>readingLists=new HashSet<>();
    @ManyToMany(mappedBy = "books")
    private Set<Genre> genres=new HashSet<>();
    @ManyToOne
    private Author author;
}
