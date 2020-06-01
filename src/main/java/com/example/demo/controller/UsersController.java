package com.example.demo.controller;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping( value = "/users")
public class UsersController {

    @Autowired
    UsersRepository UsersRepo;
    @Autowired
    CurrentUserService currentUserService;

    @GetMapping("/get1")
    public List<Users> getAllNotes() {
        return UsersRepo.findAll();
    }

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public Users validateLogin() {
        return new Users("User successfully authenticated");
    }

    @GetMapping("/get_user/{username}")
    public Optional<Users> getUser(@PathVariable( value = "username") String name)
    {
        return UsersRepo.findByUsername(name);
    }

    @PostMapping("/post1")
    public Users createNote(@Valid @RequestBody Users user1) {
        user1.setRole("User");
        user1.setActive(1);
        return UsersRepo.save(user1);
    }

    @GetMapping("/get1/{id}")
    public Optional<Users> getNoteById(@PathVariable(value = "id") Long noteId) {
        return UsersRepo.findById(noteId);

        //To HAndle Error        .orElseThrow(() -> new NotFound("Note", "id", noteId));
    }

    @PutMapping("/put_user")
    public Users putting(@Valid @RequestBody Users user , Principal principal)
    {
        Users user1 = currentUserService.CurrentUser(principal).get();
        //user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setGender(user.getGender());
        user1.setPhone(user.getPhone());
        //user1.setPassword(user.getPassword());
        user1.setActive(1);
        return UsersRepo.save(user1);
    }

    @GetMapping("/get_role/{username}")
    public String getrole(@PathVariable( value = "username") String name,Principal principal)
    {
        return currentUserService.getuserrole(principal);
    }
}
