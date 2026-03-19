package com.mhuapi.auth.model;

public record LoginResponse(
        String message,
        String phoneNumber,
        String accessToken
) {
}
