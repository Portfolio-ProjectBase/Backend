package com.project.portfolio.service.auth;

public interface AuthService {
    String createSecretPassword();
    String login(String username, String password);
}
