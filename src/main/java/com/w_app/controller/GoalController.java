package com.w_app.controller;

import com.w_app.dto.GoalResponseDTO;
import com.w_app.entity.Goal;
import com.w_app.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.w_app.utils.Constants.GOALS_ENDPOINT;

@RestController
@RequestMapping(GOALS_ENDPOINT)
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GoalResponseDTO>> getGoalsByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(goalService.getGoalsByUser(userId));
    }

    @PostMapping
    public ResponseEntity<GoalResponseDTO> createGoal(@RequestBody Goal goal) {
        return ResponseEntity.ok(goalService.createGoal(goal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteGoal(@PathVariable UUID id) {
        return ResponseEntity.ok(goalService.deleteGoal(id));
    }
}
