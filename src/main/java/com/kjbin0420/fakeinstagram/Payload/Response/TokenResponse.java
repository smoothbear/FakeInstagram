package com.kjbin0420.fakeinstagram.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class TokenResponse {
    private final String refreshToken;
    private final String accessToken;
    private final String tokenType;
}