package com.kjbin0420.fakeinstagram.Service.auth;

import lombok.Value;

public class AuthServiceImpl implements AuthService {
    @Value("${auth.jwt.exp.refresh}")
    private Long refreshExp;
    @Value
    private Long
}
