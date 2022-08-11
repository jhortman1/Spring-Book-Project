package com.flatiron.spring.SpringBookProject.service;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.dto.GetBookDTO;
import com.flatiron.spring.SpringBookProject.exception.NotFoundException;
import com.flatiron.spring.SpringBookProject.model.Author;
import com.flatiron.spring.SpringBookProject.model.Book;
import com.flatiron.spring.SpringBookProject.model.Genre;
import com.flatiron.spring.SpringBookProject.repository.AuthorRepository;
import com.flatiron.spring.SpringBookProject.repository.BookRepository;
import com.flatiron.spring.SpringBookProject.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<BookDTO> getAllBooks()
    {
        return bookRepository.findAll()
                .stream()
                .map(
                        book ->
                                modelMapper
                                        .map(book,BookDTO.class))
                .toList();
    }
    public GetBookDTO getBookById(int id) {
        return bookRepository
                .findById(id)
                .map(
                        book ->
                                modelMapper
                                        .map(book, GetBookDTO.class))
                .orElseThrow(()-> new NotFoundException("Book id "+ id + "NOT FOUND"));
    }
    public GetBookDTO create(BookDTO bookDTO)
    {
        Book newBook = modelMapper.map(bookDTO,Book.class);
        Author newAuthor = modelMapper.map(bookDTO.getAuthorName(),Author.class);
        Genre newGenre = modelMapper.map(bookDTO.getGenre(),Genre.class);
        authorRepository.save(newAuthor);
        genreRepository.save(newGenre);
        return modelMapper.map(bookRepository.save(newBook),GetBookDTO.class);
    }
    public GetBookDTO update(int id, GetBookDTO updatedBook)
    {
        Optional<Book> bookToBeUpdated = Optional.ofNullable(bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book id " + id + "NOT FOUND")));
        bookToBeUpdated.get().setTitle(updatedBook.getTitle());
        bookToBeUpdated.get().setPages(updatedBook.getPages());
        bookToBeUpdated.get().setPublished(updatedBook.getPublished());
        return modelMapper.map(bookRepository.save(bookToBeUpdated.get()),GetBookDTO.class);
    }
    public void delete(int id)
    {
        if(bookRepository.existsById(id))
        {
            bookRepository.deleteById(id);
        }
        else {
            throw new NotFoundException("Book id "+ id + "NOT FOUND");
        }
    }
}
