package com.flatiron.spring.SpringBookProject.controller;

import com.flatiron.spring.SpringBookProject.dto.BookDTO;
import com.flatiron.spring.SpringBookProject.dto.ReadingListDTO;
import com.flatiron.spring.SpringBookProject.dto.UserDTO;
import com.flatiron.spring.SpringBookProject.model.ReadingList;
import com.flatiron.spring.SpringBookProject.model.User;
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
    public UserDTO createUser(@Valid @RequestBody User user)
    {
        return userService.create(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id)
    {
        userService.delete(id);
    }
    @GetMapping("/{id}/reading_lists")
    public ReadingList getUserReadingListsByUserId(@PathVariable int id)
    {
        return  userService.getReadingListsByUserId(id);
    }
    @PostMapping("/{id}/reading_lists")
    public ReadingListDTO createReadingListForUserById(@PathVariable int id, @RequestBody ReadingListDTO readingListDTO)
    {
        return userService.createReadingListByUserId(id, readingListDTO);
    }
    @GetMapping("{id}/reading_lists/{list_id}")
    public List<BookDTO> getUserReadingListByUserId(@PathVariable int id, @PathVariable int list_id)
    {
        return userService.getReadingListsByUserIdListId(id,list_id);
    }


}
