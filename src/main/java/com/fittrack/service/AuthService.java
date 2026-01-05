package com.fittrack.service;

import com.fittrack.dto.request.LoginRequest;

public interface AuthService {
    String login(LoginRequest request);
}
