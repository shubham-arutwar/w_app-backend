package com.w_app.service;

import com.w_app.dto.GoalResponseDTO;
import com.w_app.entity.Goal;
import com.w_app.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final GoalRepository goalRepository;

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public List<GoalResponseDTO> getGoalById(UUID id) {
        return goalRepository.findById(id)
                .stream()
                .map( goal -> new GoalResponseDTO(
                        goal.getId(),
                        goal.getUser().getId(),
                        goal.getTitle(),
                        goal.getObjectives(),
                        goal.getMotivation(),
                        goal.getMetrics(),
                        goal.getStartDate(),
                        goal.getEndDate(),
                        goal.getParentGoal() != null ? goal.getParentGoal().getId() : null))
                .collect(Collectors.toList());
    }

    public List<GoalResponseDTO> getGoalsByUser(UUID userId) {
        return goalRepository.findByUserId(userId)
                .stream()
                .map( goal -> new GoalResponseDTO(
                        goal.getId(),
                        goal.getUser().getId(),
                        goal.getTitle(),
                        goal.getObjectives(),
                        goal.getMotivation(),
                        goal.getMetrics(),
                        goal.getStartDate(),
                        goal.getEndDate(),
                        goal.getParentGoal() != null ? goal.getParentGoal().getId() : null))
                .collect(Collectors.toList());
    }

    public GoalResponseDTO createGoal(Goal goal) {
        return GoalResponseDTO.fromEntity(goalRepository.save(goal));
    }

    public UUID deleteGoal(UUID id) {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goal not found with id: " + id));

        goal.setDeleted(true);
        goalRepository.save(goal);
        return goal.getId();
    }
}
