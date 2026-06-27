package com.esdnevnik.education.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esdnevnik.education.dtos.request.StudentLoginRequest;
import com.esdnevnik.education.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
  private final LoginService loginService;

  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping("/student")
  private String studentLogin(@RequestBody StudentLoginRequest data) {
    return loginService.studentLogin(data);
  }
}
