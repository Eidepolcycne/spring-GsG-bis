package com.wildcodeSchool.projetbis.controller;

import com.wildcodeSchool.projetbis.entity.Category;
import com.wildcodeSchool.projetbis.entity.Recipe;
import com.wildcodeSchool.projetbis.repository.CategoryRepository;
import com.wildcodeSchool.projetbis.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/recipes")
    public List<Recipe> getAll(){return (List<Recipe>) recipeRepository.findAll();}

    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable Long id){return recipeRepository.findById(id).get();}

    @PostMapping("recipes")
    public Recipe createArticle(@RequestParam(required = true) Long category, @RequestBody Recipe recipe) {
        Category categoryToUse = categoryRepository.findById(category).get();
        recipe.setCategory(categoryToUse);
        return recipeRepository.save(recipe);
    }

    @PutMapping("/recipes/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe){
        Recipe recipeToUpdate = recipeRepository.findById(id).get();
        recipeToUpdate.setTitle(recipe.getTitle());
        recipeToUpdate.setImage(recipe.getImage());
        recipeToUpdate.setPersonNumber(recipe.getPersonNumber());
        recipeToUpdate.setPreparationTime(recipe.getPreparationTime());
        recipeToUpdate.setCookingTime(recipe.getCookingTime());
        recipeToUpdate.setTotalTime(recipe.getTotalTime());
        recipeToUpdate.setValidated(recipe.isValidated());
        return recipeRepository.save(recipeToUpdate);
    }

    @DeleteMapping("/recipes/{id}")
    public Boolean deleteRecipe(@PathVariable Long id){
        recipeRepository.deleteById(id);
        return true;
    }
}
