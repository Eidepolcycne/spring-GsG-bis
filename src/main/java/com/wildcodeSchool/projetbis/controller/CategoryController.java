package com.wildcodeSchool.projetbis.controller;

import com.wildcodeSchool.projetbis.entity.Category;
import com.wildcodeSchool.projetbis.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/categories")
    public List<Category> getAll(){return (List<Category>) categoryRepository.findAll();}

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable Long id){return categoryRepository.findById(id).get();}

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {return categoryRepository.save(category);}

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category){
        Category categoryToUpdate = categoryRepository.findById(id).get();
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setLogo(category.getLogo());
        return categoryRepository.save(categoryToUpdate);
    }

    @DeleteMapping("/categories/{id}")
    public Boolean deleteCategory(@PathVariable Long id){
        categoryRepository.deleteById(id);
        return true;
    }
}
