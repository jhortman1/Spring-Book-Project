package com.flatiron.spring.SpringBookProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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

    @NotBlank
    @NotNull
    private String title;

    @Min(0)
    private int pages;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate published;

    @ManyToMany
    private Set<ReadingList>readingLists=new HashSet<>();

    @ManyToMany(mappedBy = "books")
    private Set<Genre> genres=new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "authorId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    public void addGenre(Genre newGenre) {
        genres.add(newGenre);
    }
    public void addReadingList(ReadingList readingList)
    {
        readingLists.add(readingList);
    }
}
