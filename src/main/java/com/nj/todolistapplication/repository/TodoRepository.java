package com.nj.todolistapplication.repository;


import com.nj.todolistapplication.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {


    List<Todo> findByCompleted(Boolean completed);

    List<Todo> findByTitleContainingIgnoreCase(String title);
}
