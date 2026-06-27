package com.esdnevnik.education.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "directors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Director {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", updatable = false, nullable = false)
  private String id;

  @NotBlank(message = "Director must have a name.")
  @Column(name = "name", nullable = false, updatable = true)
  private String name;

  @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
  @JoinColumn(name = "school_id", nullable = false, unique = true, foreignKey = @ForeignKey(name = "fk_director_school"))
  private School school;

  @Column(name = "email", nullable = false, updatable = true)
  @NotBlank(message = "Director must have a email, required for authentication.")
  private String email;

  @Column(name = "password", nullable = false, updatable = true)
  @JsonIgnore
  @NotBlank(message = "Director must have a password, required for authentication.")
  private String password;
}
