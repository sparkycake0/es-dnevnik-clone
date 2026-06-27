package com.esdnevnik.education.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schools")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JsonIgnore
  @Column(name = "id", unique = true, updatable = false, nullable = false)
  public String id;

  @NotBlank(message = "School must have a name.")
  @Column(name = "name", nullable = false, updatable = true)
  public String name;

  @NotBlank(message = "School must have place where it is.")
  @Column(name = "place", updatable = true, nullable = false)
  public String place;

  @NotNull
  @PositiveOrZero(message = "Number of students in school can't be negative number")
  public int size;
}
