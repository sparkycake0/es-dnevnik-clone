package com.esdnevnik.education.entities;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolClass {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true, updatable = false)
  private String id;

  @Column(name = "identifier", nullable = false, updatable = false)
  @NotBlank(message = "Class must have a identifier")
  private String identifier;

  @Column(name = "size", nullable = false, updatable = true)
  @PositiveOrZero(message = "Class cannot have negative number of students")
  private int size;

  @Column(name = "grade", updatable = false, nullable = false)
  @PositiveOrZero(message = "Grade cannot be a negative number")
  @Range(min = 1, max = 8, message = "Grade must be between first and eighth.")
  private int grade;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "school_id", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_class_school"))
  private School school;
}
