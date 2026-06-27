package com.esdnevnik.education.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false, unique = true)
  private String id;

  @NotBlank(message = "Teacher must have a name")
  @Column(name = "name", nullable = false, updatable = false)
  private String name;

  @Column(name = "email", nullable = false, updatable = true)
  @NotBlank(message = "Teacher must have a email, required for authentication.")
  private String email;

  @Column(name = "password", nullable = false, updatable = true)
  @JsonIgnore
  @NotBlank(message = "Teacher must have a password, required for authentication.")
  private String password;
}
