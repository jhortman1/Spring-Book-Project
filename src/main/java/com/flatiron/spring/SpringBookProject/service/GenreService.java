package com.flatiron.spring.SpringBookProject.service;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.dto.GetBookDTO;
import com.flatiron.spring.SpringBookProject.dto.GetGenreDTO;
import com.flatiron.spring.SpringBookProject.exception.NotFoundException;
import com.flatiron.spring.SpringBookProject.model.Book;
import com.flatiron.spring.SpringBookProject.model.Genre;
import com.flatiron.spring.SpringBookProject.repository.BookRepository;
import com.flatiron.spring.SpringBookProject.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

public List<GetBookDTO> getAllBooksInGenreById(int id) {
    Genre g = genreRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return bookRepository.findAll()
                .stream()
                .filter(
                        (book)->book.getGenres().contains(g))
                .toList()
                .stream()
                .map(
                        book -> modelMapper.map(book,GetBookDTO.class))
                .toList();
    }

}
