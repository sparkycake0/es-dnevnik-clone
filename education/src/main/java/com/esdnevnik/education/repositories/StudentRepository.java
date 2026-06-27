package com.esdnevnik.education.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esdnevnik.education.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
  Optional<Student> findByEmail(String email);
}
