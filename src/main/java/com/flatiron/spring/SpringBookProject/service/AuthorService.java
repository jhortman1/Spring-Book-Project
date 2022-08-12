package com.flatiron.spring.SpringBookProject.service;

import com.flatiron.spring.SpringBookProject.dto.AuthorDTO;
import com.flatiron.spring.SpringBookProject.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<AuthorDTO> getAll() {
        return authorRepository
                .findAll()
                .stream()
                .map(
                        author -> modelMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
    }
}
