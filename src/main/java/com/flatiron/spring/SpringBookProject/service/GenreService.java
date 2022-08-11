package com.flatiron.spring.SpringBookProject.service;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.exception.NotFoundException;
import com.flatiron.spring.SpringBookProject.model.Book;
import com.flatiron.spring.SpringBookProject.model.Genre;
import com.flatiron.spring.SpringBookProject.repository.BookRepository;
import com.flatiron.spring.SpringBookProject.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ModelMapper modelMapper;

public List<BookDTO> getAllBooksInGenreById(int id)
    {
        Genre genre = genreRepository.findById(id).orElseThrow(()->new NotFoundException("Genre id "+ id + "NOT FOUND"));
        return bookRepository
                .findAll()
                .stream()
                .map(
                        book -> modelMapper
                                .map(book,BookDTO.class))
                .filter(
                        book ->
                                book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

}
