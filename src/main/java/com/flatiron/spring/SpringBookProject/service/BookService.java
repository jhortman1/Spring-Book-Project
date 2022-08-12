package com.flatiron.spring.SpringBookProject.service;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.dto.CreateBookDTO;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

        public List<GetBookDTO> getAllBooks()
    {
        return bookRepository.findAll()
                .stream()
                .map(
                        book ->
                                modelMapper
                                        .map(book,GetBookDTO.class))
                .toList();
    }

    public GetBookDTO getBookById(int id) {
        return bookRepository
                .findById(id)
                .map(
                        book ->
                                modelMapper
                                        .map(book, GetBookDTO.class))
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public GetBookDTO update(int id, BookDTO updatedBook)
    {
        Optional<Book> bookToBeUpdated = Optional.ofNullable(bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        bookToBeUpdated.get().setTitle(updatedBook.getTitle());
        bookToBeUpdated.get().setPages(updatedBook.getPages());
        bookToBeUpdated.get().setPublished(updatedBook.getPublished());
        return modelMapper.map(bookRepository.save(bookToBeUpdated.get()),GetBookDTO.class);
    }
    public void delete(int id)
    {
        Book b = bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Set<Genre> g = b.getGenres();
        g.stream().filter((gg)->gg.getBooks().contains(b)).forEach(genre -> genre.getBooks().remove(b));
        Author a = b.getAuthor();
        a.getBooks().remove(b);
        if(bookRepository.existsById(id))
        {
            bookRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public BookDTO create(CreateBookDTO bookDTO)
    {
        Book newBook = modelMapper.map(bookDTO,Book.class);
        Author newAuthor = new Author();
        Genre newGenre = new Genre();
        newAuthor.setName(bookDTO.getAuthorName());
        newGenre.setName(bookDTO.getGenre());
        Genre saveG = genreRepository.save(newGenre);
        Author saveA = authorRepository.save(newAuthor);
        newBook.addGenre(saveG);
        newBook.setAuthor(saveA);
        saveG.addBook(newBook);
        saveA.addBook(newBook);
        BookDTO y = modelMapper.map(bookRepository.save(newBook),BookDTO.class);
        y.setAuthorName(bookDTO.getAuthorName());
        y.setGenreDTO(bookDTO.getGenre());
        return y;
    }
}
