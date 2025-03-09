package com.w_app.w_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
@Getter
@Setter
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String task;

    @Column(nullable = false)
    private Boolean isDone = false;

    @Column(nullable = false, unique = true)
    private Integer taskOrder;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime modifiedOn;

    @Column(nullable = false)
    private String modifiedBy;

    @Column(nullable = false)
    private Long userId;
}
