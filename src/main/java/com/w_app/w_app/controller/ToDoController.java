package com.w_app.w_app.controller;

import com.w_app.w_app.entity.ToDo;
import com.w_app.w_app.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    // Get all todos for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ToDo>> getAllToDosByUser(@PathVariable Long userId) {
        List<ToDo> todos = toDoService.getAllToDosByUser(userId);
        return ResponseEntity.ok(todos);
    }

//    // Get a single todo by ID (must belong to the user)
//    @GetMapping("/{id}/user/{userId}")
//    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id, @PathVariable Long userId) {
//        Optional<ToDo> toDo = toDoService.getToDoByIdAndUser(id, userId);
//        return toDo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

//    // Create a new todo
//    @PostMapping
//    public ToDo createToDo(@RequestBody ToDo toDo) {
//        return toDoService.createToDo(toDo);
//    }

//    // Update an existing todo (must belong to the user)
//    @PutMapping("/{id}/user/{userId}")
//    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @PathVariable Long userId, @RequestBody ToDo toDo) {
//        return ResponseEntity.ok(toDoService.updateToDo(id, userId, toDo));
//    }
//
//    // Delete a todo (must belong to the user)
//    @DeleteMapping("/{id}/user/{userId}")
//    public ResponseEntity<Void> deleteToDo(@PathVariable Long id, @PathVariable Long userId) {
//        toDoService.deleteToDo(id, userId);
//        return ResponseEntity.noContent().build();
//    }
}
