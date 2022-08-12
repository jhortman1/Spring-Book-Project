package com.flatiron.spring.SpringBookProject.service;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.dto.ReadingListDTO;
import com.flatiron.spring.SpringBookProject.dto.UserDTO;
import com.flatiron.spring.SpringBookProject.model.ReadingList;
import com.flatiron.spring.SpringBookProject.model.User;
import com.flatiron.spring.SpringBookProject.repository.ReadingListRepository;
import com.flatiron.spring.SpringBookProject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReadingListRepository readingListRepository;
    @Autowired
    ModelMapper modelMapper;

    public UserDTO create(User user)
    {
        return modelMapper.map(userRepository.save(user),UserDTO.class);
    }

    public void delete(int id)
    {
        if(userRepository.existsById(id))
        {
            userRepository.deleteById(id);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public ReadingList getReadingListsByUserId(int id) {
        User user = userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(user.getReadingLists(),ReadingList.class);
    }
    public List<BookDTO> getReadingListsByUserIdListId(int id, int list_id)
    {
        ReadingList readingList;
        if(!userRepository.existsById(id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else if(!readingListRepository.existsById(list_id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            readingList = readingListRepository.findById(list_id).get();
        }
        return readingList.getBooks().stream().map(book->modelMapper.map(book, BookDTO.class)).toList();
    }
    public ReadingListDTO createReadingListByUserId(int id, ReadingListDTO readingListDTO)
    {
        if(!userRepository.existsById(id))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Optional<User> u1 = userRepository.findById(id);

        ReadingList rl = modelMapper.map(readingListDTO,ReadingList.class);
        u1.get().addReadingList(readingListRepository.save(rl));
        User x = userRepository.save(u1.get());
        return modelMapper.map(readingListRepository.save(rl),ReadingListDTO.class);
    }


}
