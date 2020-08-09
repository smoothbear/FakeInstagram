package com.kjbin0420.fakeinstagram.Controller;

import com.kjbin0420.fakeinstagram.Payload.Request.LoginRequest;
import com.kjbin0420.fakeinstagram.Payload.Response.TokenResponse;
import com.kjbin0420.fakeinstagram.Service.auth.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return authService.signIn(request);
    }

    @PutMapping
    public TokenResponse refreshToken(@RequestHeader("Refresh-Token") String request) {
        return authService.refreshToken(request);
    }
}