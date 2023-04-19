package com.wildcodeSchool.projetbis.repository;

import com.wildcodeSchool.projetbis.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Long> {
    List<Step> findStepsByRecipeId(Long id);
}
