package com.wildcodeSchool.projetbis.controller;

import com.wildcodeSchool.projetbis.entity.User;
import com.wildcodeSchool.projetbis.repository.ArticleRepository;
import com.wildcodeSchool.projetbis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/users")
    public List<User> getAll(){return(List<User>) userRepository.findAll();}
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){return userRepository.findById(id).get();}

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {return userRepository.save(user);}
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setNickname(user.getNickname());
        userToUpdate.setMail(user.getMail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());
        return userRepository.save(userToUpdate);
    }
    @DeleteMapping("/users/{id}")
    public Boolean deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return true;
    }

}
