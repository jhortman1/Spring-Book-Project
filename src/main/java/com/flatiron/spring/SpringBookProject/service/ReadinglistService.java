package com.flatiron.spring.SpringBookProject.service;

import com.flatiron.spring.SpringBookProject.dto.ReadingListDTO;
import com.flatiron.spring.SpringBookProject.repository.ReadingListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadinglistService {
    @Autowired
    ReadingListRepository readingListRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<ReadingListDTO> getAll()
    {
        return readingListRepository
                .findAll()
                .stream()
                .map(
                        readingList -> modelMapper.map(readingList,ReadingListDTO.class))
                .collect(Collectors.toList());
    }
}
