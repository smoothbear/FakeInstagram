package com.kjbin0420.fakeinstagram.Security;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${auth.jwt.secret}")
    private String secretKey;
}