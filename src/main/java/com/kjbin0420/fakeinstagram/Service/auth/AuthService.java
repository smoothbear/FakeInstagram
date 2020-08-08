package com.kjbin0420.fakeinstagram.Service.auth;

import com.kjbin0420.fakeinstagram.Payload.Request.LoginRequest;
import com.kjbin0420.fakeinstagram.Payload.Response.TokenResponse;

public interface AuthService {
    TokenResponse signIn(LoginRequest loginRequest);
    TokenResponse refreshToken(String refreshToken);
}