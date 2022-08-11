package com.flatiron.spring.SpringBookProject.service;

import com.flatiron.spring.SpringBookProject.model.Author;
import com.flatiron.spring.SpringBookProject.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository repository;
    @Autowired
    ModelMapper modelMapper;
}
