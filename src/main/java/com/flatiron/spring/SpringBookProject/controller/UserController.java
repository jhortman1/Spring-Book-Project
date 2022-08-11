package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.ReadingListDTO;
import com.flatiron.spring.SpringBookProject.dto.UserDTO;
import com.flatiron.spring.SpringBookProject.model.ReadingList;
import com.flatiron.spring.SpringBookProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO)
    {
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id)
    {

    }
    @GetMapping("/{id}/reading_lists")
    public List<ReadingList> getUserReadingListsByUserId()
    {
        return  null;
    }
    @PostMapping("/{id}/reading_lists")
    public ReadingListDTO createReadingListForUserById()
    {
        return null;
    }
    @GetMapping("{id}/reading_lists/{list_id}")
    public List<ReadingListDTO> getUserReadingListByUserId()
    {
        return null;
    }

}
