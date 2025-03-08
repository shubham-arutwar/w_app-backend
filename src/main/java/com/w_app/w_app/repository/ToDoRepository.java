package com.w_app.w_app.repository;

import com.w_app.w_app.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByUserId(Long userId);
//    Optional<ToDo> findByIdAndUserId(Long id, Long userId);
}
