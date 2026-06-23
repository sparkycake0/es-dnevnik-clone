package com.esdnevnik.education.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.esdnevnik.education.services.LoginService;

@RestController
public class LoginController {
  public final LoginService loginService;

  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }
}
