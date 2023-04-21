package com.wildcodeSchool.projetbis.controller;

import com.wildcodeSchool.projetbis.entity.Step;
import com.wildcodeSchool.projetbis.repository.RecipeRepository;
import com.wildcodeSchool.projetbis.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class StepController {
    @Autowired
    StepRepository stepRepository;
    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/steps")
    public List<Step> getAll(){return(List<Step>) stepRepository.findAll();}

    @GetMapping("/steps/{id}")
    public Step getStep(@PathVariable Long id){return stepRepository.findById(id).get();}

    @PutMapping("/steps/{id}")
    public Step updateStep(@PathVariable Long id, @RequestBody Step step){
        Step stepToUpdate = stepRepository.findById(id).get();
        stepToUpdate.setTitle(step.getTitle());
        stepToUpdate.setStepNumber(step.getStepNumber());
        stepToUpdate.setDescription(step.getDescription());
        return stepRepository.save(stepToUpdate);
    }

    @DeleteMapping("/steps/{id}")
    public Boolean deleteStep(@PathVariable Long id){
        stepRepository.deleteById(id);
        return true;
    }
}
