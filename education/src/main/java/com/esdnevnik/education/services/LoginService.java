package com.esdnevnik.education.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esdnevnik.education.dtos.request.StudentLoginRequest;
import com.esdnevnik.education.entities.Student;
import com.esdnevnik.education.repositories.StudentRepository;

@Service
public class LoginService {
  private final StudentRepository studentRep;

  public LoginService(StudentRepository studentRep) {
    this.studentRep = studentRep;
  }

  public String studentLogin(StudentLoginRequest login) {
    Optional<Student> student = studentRep.findByEmail(login.email());

    String a = "a";
    return a;
  }
}
