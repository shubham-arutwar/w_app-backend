package com.w_app.controller;

import com.w_app.dto.TaskResponseDTO;
import com.w_app.entity.Task;
import com.w_app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.w_app.utils.Constants.TASKS_ENDPOINT;

@RestController
@RequestMapping(TASKS_ENDPOINT)
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskResponseDTO>> getTasksByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(taskService.getTasksByUser(userId));
    }

    @GetMapping("/goal/{goalId}")
    public ResponseEntity<List<TaskResponseDTO>> getTasksByGoal(@PathVariable UUID goalId) {
        return ResponseEntity.ok(taskService.getTasksByGoal(goalId));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteTask(@PathVariable UUID id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

}
