package com.w_app.dto;

import com.w_app.entity.Goal;
import com.w_app.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoalResponseDTO {
    private UUID id;
    private UUID userId;
    private String title;
    private String objectives;
    private String motivation;
    private String metrics;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID parentGoal;

    public static GoalResponseDTO fromEntity(Goal goal) {
        return GoalResponseDTO.builder()
                .id(goal.getId())
                .userId(goal.getUser().getId())
                .title(goal.getTitle())
                .objectives(goal.getObjectives())
                .motivation(goal.getMotivation())
                .metrics(goal.getMetrics())
                .startDate(goal.getStartDate())
                .endDate(goal.getEndDate())
                .parentGoal(goal.getParentGoal() != null ? goal.getParentGoal().getId() : null)
                .build();
    }
}
