package com.flatiron.spring.SpringBookProject.repository;
import com.flatiron.spring.SpringBookProject.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository  extends JpaRepository<Genre, Integer> {
}
