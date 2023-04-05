package com.wildcodeSchool.projetbis.repository;

import com.wildcodeSchool.projetbis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
