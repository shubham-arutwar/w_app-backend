package com.w_app.entity;

import jakarta.persistence.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.w_app.utils.Constants.SERVER_NAME;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_tasks_users"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "goal_id", foreignKey = @ForeignKey(name = "fk_tasks_goals"))
    private Goal goal;

    @Column(name = "task", columnDefinition = "TEXT", nullable = false)
    private String task;

    @Column(name = "is_done", nullable = false)
    private boolean isDone = false;

    @Column(name = "task_order", nullable = false)
    private int taskOrder;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "created_on", updatable = false)
    @CurrentTimestamp
    private LocalDateTime createdOn;

    @Column(name = "modified_by", columnDefinition = "TEXT")
    private String modifiedBy;

    @Column(name = "modified_on")
    @CurrentTimestamp
    private LocalDateTime modifiedOn;

    @PrePersist
    @PreUpdate
    public void setModifiedByUser() {
        if (this.modifiedBy == null || this.modifiedBy.isEmpty()) {
            this.modifiedBy = SERVER_NAME;
        }
    }

}
