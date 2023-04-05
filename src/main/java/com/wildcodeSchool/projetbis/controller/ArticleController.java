package com.wildcodeSchool.projetbis.controller;

import com.wildcodeSchool.projetbis.entity.Article;
import com.wildcodeSchool.projetbis.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Article> getAll(){return(List<Article>) articleRepository.findAll();}

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable Long id){return articleRepository.findById(id).get();}

    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article) {return articleRepository.save(article);}

    @PutMapping("/articles/{id}")
    public Article updateUser(@PathVariable Long id, @RequestBody Article article){
        Article articleToUpdate = articleRepository.findById(id).get();
        articleToUpdate.setTitle(articleToUpdate.getTitle());
        articleToUpdate.setImage(articleToUpdate.getImage());
        articleToUpdate.setContent(articleToUpdate.getContent());
        return articleRepository.save(articleToUpdate);
    }

    @DeleteMapping("/articles/{id}")
    public Boolean deleteArticle(@PathVariable Long id){
        articleRepository.deleteById(id);
        return true;
    }

}