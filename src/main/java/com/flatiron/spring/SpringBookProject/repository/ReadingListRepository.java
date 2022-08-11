package com.flatiron.spring.SpringBookProject.repository;
import com.flatiron.spring.SpringBookProject.model.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingListRepository  extends JpaRepository<ReadingList, Integer> {
}
