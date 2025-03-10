package com.w_app.repository;

import com.w_app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByUserId(UUID userId);
    List<Task> findByGoalId(UUID goalId);
    List<Task> findByUserIdAndIsDeletedFalse(UUID userId);
}
