package com.w_app.service;

import com.w_app.dto.TaskResponseDTO;
import com.w_app.entity.Task;
import com.w_app.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    public List<TaskResponseDTO> getTasksByUser(UUID userId) {
        return taskRepository.findByUserId(userId)
                .stream()
                .map(task -> new TaskResponseDTO(
                        task.getId(),
                        task.getGoal() != null ? task.getGoal().getId() : null,
                        task.getTask(),
                        task.isDone(),
                        task.getTaskOrder()))
                .collect(Collectors.toList());
    }


    public List<TaskResponseDTO> getTasksByGoal(UUID goalId) {
        return taskRepository.findByGoalId(goalId)
                .stream()
                .map(task -> new TaskResponseDTO(
                        task.getId(),
                        task.getGoal() != null ? task.getGoal().getId() : null,
                        task.getTask(),
                        task.isDone(),
                        task.getTaskOrder()))
                .collect(Collectors.toList());
    }

    public TaskResponseDTO createTask(Task task) {
        return TaskResponseDTO.fromEntity(taskRepository.save(task));
    }

    public UUID deleteTask(UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        task.setDeleted(true);
        taskRepository.save(task);
        return task.getId();
    }

}
