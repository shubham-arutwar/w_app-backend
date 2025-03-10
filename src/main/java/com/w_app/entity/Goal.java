package com.w_app.entity;

import jakarta.persistence.*;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_goals_users"))
    private User user;

    @Column(name = "title", columnDefinition = "TEXT", nullable = false)
    private String title;

    @Column(name = "objectives", columnDefinition = "TEXT")
    private String objectives;

    @Column(name = "motivation", columnDefinition = "TEXT")
    private String motivation;

    @Column(name = "metrics", columnDefinition = "TEXT")
    private String metrics;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "parent_goal_id", foreignKey = @ForeignKey(name = "fk_goals_parent_goal"))
    private Goal parentGoal;

    @Column(name = "priority", length = 10)
    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.Medium;

    @Column(name = "progress", precision = 5, scale = 2)
    private BigDecimal progress = BigDecimal.valueOf(0.00);

    @Column(name = "status", length = 20)
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_STARTED;

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

    public enum Priority {
        High, Medium, Low
    }

    public enum Status {
        NOT_STARTED, IN_PROGRESS, COMPLETED, ON_HOLD
    }
}
