package com.kjbin0420.fakeinstagram.Domain.Response;

import lombok.Getter;

@Getter
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
}
