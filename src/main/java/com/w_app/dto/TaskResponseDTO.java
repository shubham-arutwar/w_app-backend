package com.w_app.dto;

import com.w_app.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponseDTO {
    private UUID id;
    private UUID goalId;
    private String task;
    private boolean isDone;
    private int taskOrder;

    public static TaskResponseDTO fromEntity(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .task(task.getTask())
                .isDone(task.isDone())
                .taskOrder(task.getTaskOrder())
                .goalId(task.getGoal() != null ? task.getGoal().getId() : null)
                .build();
    }
}
