package com.wildcodeSchool.projetbis.controller;

import com.wildcodeSchool.projetbis.entity.RecipeIngredient;
import com.wildcodeSchool.projetbis.repository.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
public class RecipeIngredientController {
    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    @GetMapping("/quantity")
    public List<RecipeIngredient> getAll(){return (List<RecipeIngredient>) recipeIngredientRepository.findAll();}
}

