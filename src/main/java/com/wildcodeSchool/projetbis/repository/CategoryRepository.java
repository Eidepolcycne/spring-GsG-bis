package com.wildcodeSchool.projetbis.repository;

import com.wildcodeSchool.projetbis.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {
}
