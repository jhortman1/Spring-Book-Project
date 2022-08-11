package com.flatiron.spring.SpringBookProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Table(name = "ReadingList")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ReadingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private User user;
    @ManyToMany(mappedBy = "readingLists")
    Set<Book> books=new HashSet<>();
}
