package com.flatiron.spring.SpringBookProject.service;

import com.flatiron.spring.SpringBookProject.dto.ReadingListDTO;
import com.flatiron.spring.SpringBookProject.dto.UserDTO;
import com.flatiron.spring.SpringBookProject.exception.NotFoundException;
import com.flatiron.spring.SpringBookProject.exception.UsernameAlreadyExists;
import com.flatiron.spring.SpringBookProject.model.ReadingList;
import com.flatiron.spring.SpringBookProject.model.User;
import com.flatiron.spring.SpringBookProject.repository.ReadingListRepository;
import com.flatiron.spring.SpringBookProject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

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
        if(userRepository.findAll().stream().anyMatch((u)->u.getUsername().equals(u.getUsername())))
        {
            throw new UsernameAlreadyExists("Username TAKE, Please enter a different username");
        }
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
            throw new NotFoundException("UserID NOT FOUND");
        }
    }
    public List<ReadingListDTO> getReadingListsByUserId(int id) {
        return readingListRepository
                .findAll()
                .stream()
                .filter(
                        (rl)->rl.getUser().getId()==id)
                .map(
                        (rl)->modelMapper.map(rl,ReadingListDTO.class))
                .toList();
    }
    public ReadingListDTO createReadingListByUserId(int id, ReadingListDTO readingListDTO)
    {
        if(!userRepository.existsById(id))
        {
            throw new NotFoundException("User id: "+ id + "NOT FOUND");
        }
        return modelMapper
                .map(
                        readingListRepository
                                .save(
                                        modelMapper
                                                .map(readingListDTO,ReadingList.class))
                        ,ReadingListDTO.class);
    }
    public ReadingListDTO getReadingListsByUserIdListId(int id, int list_id)
    {
        List<ReadingListDTO> readingListDTO;
        if(!userRepository.existsById(id))
        {
            throw new NotFoundException("User id: "+ id + "NOT FOUND");
        }
        else if(!readingListRepository.existsById(list_id))
        {
            throw new NotFoundException("List id: "+ id + "NOT FOUND");
        }
        else {
            readingListDTO = readingListRepository
                    .findAll()
                    .stream()
                    .filter(
                            (rl)->rl.getUser().getId()==id)
                    .filter(
                            (rl)->rl.getId()==list_id)
                    .map((rl)->modelMapper.map(rl,ReadingListDTO.class)).toList();
        }
        return readingListDTO.get(0);
    }

}
