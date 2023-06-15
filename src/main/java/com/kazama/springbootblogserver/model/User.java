package com.kazama.springbootblogserver.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable = false, columnDefinition = "varchar(36)")
    private String userId;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(20)", unique = true)
    private String email;

    @Column(name = "full_name", nullable = false, columnDefinition = "varchar(30)")
    private String fullName;

    @Column(name = "profile_name", nullable = false, columnDefinition = "varchar(20)", unique = true)
    private String profileName;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(72)")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition = "varchar(5)")
    private Role role;

    @Column(name = "is_active")
    private Boolean IsActive = true;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Instant passwordChangeAt = Instant.now();
}
