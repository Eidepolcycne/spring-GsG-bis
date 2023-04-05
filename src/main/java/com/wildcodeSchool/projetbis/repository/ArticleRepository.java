package com.wildcodeSchool.projetbis.repository;

import com.wildcodeSchool.projetbis.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
