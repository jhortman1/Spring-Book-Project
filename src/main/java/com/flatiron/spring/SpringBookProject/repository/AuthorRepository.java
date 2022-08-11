package com.flatiron.spring.SpringBookProject.repository;

import com.flatiron.spring.SpringBookProject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
