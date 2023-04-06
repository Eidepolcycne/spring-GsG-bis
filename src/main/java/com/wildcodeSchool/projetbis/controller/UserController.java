package com.wildcodeSchool.projetbis.controller;

import com.wildcodeSchool.projetbis.entity.Article;
import com.wildcodeSchool.projetbis.entity.User;
import com.wildcodeSchool.projetbis.repository.ArticleRepository;
import com.wildcodeSchool.projetbis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
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

//    @GetMapping("users/favorites_article")
//    public User getFavoriteArticle(@RequestParam Long idUser){
//        Optional<User> optionalUser = userRepository.findById(idUser);
//        User user = new User();
//        if (optionalUser.isPresent()){
//            user = optionalUser.get();
//        }
//        List<Article> courses = new ArrayList<>();
//        Method method = getMethod(user, "getArticles", new Class[]{});
//        if (method != null) {
//            try {
//                courses = (List<Article>) method.invoke(user);
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//        return "favorites_article";
//    }

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
