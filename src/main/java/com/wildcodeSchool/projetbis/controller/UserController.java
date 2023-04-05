package com.wildcodeSchool.projetbis.controller;

import com.wildcodeSchool.projetbis.entity.User;
import com.wildcodeSchool.projetbis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll(){return(List<User>) userRepository.findAll();}
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){return userRepository.findById(id).get();}
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {return userRepository.save(user);}
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setNickname(userToUpdate.getNickname());
        userToUpdate.setMail(userToUpdate.getMail());
        userToUpdate.setPassword(userToUpdate.getPassword());
        userToUpdate.setRole(userToUpdate.getRole());
        return userRepository.save(userToUpdate);
    }
    @DeleteMapping("/users/{id}")
    public Boolean deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return true;
    }

}
