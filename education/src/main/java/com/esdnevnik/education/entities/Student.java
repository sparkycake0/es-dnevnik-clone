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
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false, unique = true)
  @JsonIgnore
  private String id;

  @Column(name = "name", updatable = true)
  @NotBlank(message = "Student must have a name.")
  private String name;

  @Column(name = "email", updatable = true)
  @NotBlank(message = "Student must have a email, required for authentication.")
  private String email;

  @Column(name = "password", updatable = true)
  @NotBlank(message = "Student must have a password, required for authentication.")
  @JsonIgnore
  private String password;
}
