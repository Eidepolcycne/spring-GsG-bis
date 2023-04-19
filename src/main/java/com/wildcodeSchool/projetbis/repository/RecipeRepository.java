package com.wildcodeSchool.projetbis.repository;

import com.wildcodeSchool.projetbis.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findRecipesByCategoryId(Long categoryId);
}
