package com.w_app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 15, unique = true)
    private String phoneNumber;

    @Column(name = "password_hash", nullable = false, columnDefinition = "TEXT")
    private String passwordHash;

    @Column(name = "profile_picture", columnDefinition = "TEXT")
    private String profilePicture;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender", length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "timezone", length = 50, nullable = false)
    private String timezone = "UTC";

    @Column(name = "language", length = 10, nullable = false)
    private String language = "en";

    @Column(name = "status", length = 20)
    @Enumerated(EnumType.STRING)
    private Status status = Status.active;

    @Column(name = "last_login")
    @CurrentTimestamp
    private LocalDateTime lastLogin;

    @Column(name = "account_type", length = 20)
    private String accountType = "free";

    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified = false;

    @Column(name = "phone_verified", nullable = false)
    private boolean phoneVerified = false;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin = false;

    @Column(name = "created_on", updatable = false)
    @CurrentTimestamp
    private LocalDateTime createdOn;

    @Column(name = "modified_by", columnDefinition = "TEXT")
    private String modifiedBy;

    @Column(name = "modified_on")
    @CurrentTimestamp
    private LocalDateTime modifiedOn;

    public enum Gender {
        Male, Female
    }

    public enum Status {
        active, suspended, deleted
    }
}
