package com.fittrack.service.impl;

import com.fittrack.dto.request.LoginRequest;
import com.fittrack.exception.BusinessException;
import com.fittrack.model.entity.User;
import com.fittrack.repository.UserRepository;
import com.fittrack.service.AuthService;
import com.fittrack.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new BusinessException("Invalid email or password"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BusinessException("Invalid email or password");
        }

        return jwtService.generateToken(user);
    }
}