package com.wildcodeSchool.projetbis.repository;

import com.wildcodeSchool.projetbis.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}
