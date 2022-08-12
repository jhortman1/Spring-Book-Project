package com.flatiron.spring.SpringBookProject.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "Author")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Book> books=new HashSet<>();
    public void addBook(Book book)
    {
        books.add(book);
    }
}
