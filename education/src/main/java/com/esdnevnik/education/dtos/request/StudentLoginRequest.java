package com.esdnevnik.education.dtos.request;

public record StudentLoginRequest(
    String email,
    String password) {
}
