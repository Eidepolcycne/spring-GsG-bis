package com.wildcodeSchool.projetbis.controller;

import com.wildcodeSchool.projetbis.entity.Ingredient;
import com.wildcodeSchool.projetbis.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class IngredientController {
    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping("/ingredients")
    public List<Ingredient> getAll(){return (List<Ingredient>) ingredientRepository.findAll();}

    @GetMapping("/ingredients/{id}")
    public Ingredient getIngredient(@PathVariable Long id){return ingredientRepository.findById(id).get();}

    @PostMapping("/ingredients")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {return ingredientRepository.save(ingredient);}

    @PutMapping("/ingredients/{id}")
    public Ingredient updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient){
        Ingredient ingredientToUpdate = ingredientRepository.findById(id).get();
        ingredientToUpdate.setName(ingredient.getName());
        ingredientToUpdate.setLogo(ingredient.getLogo());
        return ingredientRepository.save(ingredientToUpdate);
    }

    @DeleteMapping("/ingredients/{id}")
    public Boolean deleteIngredient(@PathVariable Long id){
        ingredientRepository.deleteById(id);
        return true;
    }

}
