package com.mhuapi.auth.service;

import com.mhuapi.auth.model.LoginRequest;
import com.mhuapi.auth.model.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@Service
public class AuthService {

    private static final Map<String, String> USERS = Map.of(
            "+919876543210", "Password@123",
            "+15551234567", "Secret@123"
    );

    public LoginResponse login(LoginRequest request) {
        String expectedPassword = USERS.get(request.phoneNumber());
        if (expectedPassword == null || !expectedPassword.equals(request.password())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid phone number or password");
        }

        String tokenPayload = request.phoneNumber() + ":authenticated";
        String accessToken = Base64.getEncoder().encodeToString(tokenPayload.getBytes(StandardCharsets.UTF_8));
        return new LoginResponse("Login successful", request.phoneNumber(), accessToken);
    }
}
