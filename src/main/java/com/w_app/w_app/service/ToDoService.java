package com.w_app.w_app.service;

import com.w_app.w_app.entity.ToDo;
import com.w_app.w_app.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    // Get all todos for a specific user
    public List<ToDo> getAllToDosByUser(Long userId) {
        return toDoRepository.findByUserId(userId);
    }

//    // Get a single todo by ID and user
//    public Optional<ToDo> getToDoByIdAndUser(Long id, Long userId) {
//        return toDoRepository.findByIdAndUserId(id, userId);
//    }
//
//    // Create a new todo
//    public ToDo createToDo(ToDo toDo) {
//        return toDoRepository.save(toDo);
//    }
//
//    // Update an existing todo (only if it belongs to the user)
//    public ToDo updateToDo(Long id, Long userId, ToDo toDo) {
//        return toDoRepository.findByIdAndUserId(id, userId)
//                .map(existing -> {
//                    existing.setTask(toDo.getTask());
//                    existing.setIsDone(toDo.getIsDone());
//                    existing.setTaskOrder(toDo.getTaskOrder());
//                    existing.setModifiedBy(toDo.getModifiedBy());
//                    return toDoRepository.save(existing);
//                })
//                .orElseThrow(() -> new RuntimeException("ToDo not found or does not belong to user"));
//    }
//
//    // Delete a todo (only if it belongs to the user)
//    public void deleteToDo(Long id, Long userId) {
//        ToDo toDo = toDoRepository.findByIdAndUserId(id, userId)
//                .orElseThrow(() -> new RuntimeException("ToDo not found or does not belong to user"));
//        toDoRepository.delete(toDo);
//    }
}
