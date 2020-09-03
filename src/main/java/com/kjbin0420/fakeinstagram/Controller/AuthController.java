package com.kjbin0420.fakeinstagram.Controller;

import com.kjbin0420.fakeinstagram.Payload.Request.LoginRequest;
import com.kjbin0420.fakeinstagram.Payload.Response.TokenResponse;
import com.kjbin0420.fakeinstagram.Service.auth.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;
    
    @PostMapping
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        log.debug(request.toString());
        return authService.signIn(request);
    }

    @PutMapping
    public TokenResponse refreshToken(@RequestHeader("refresh_token") String request) {
        return authService.refreshToken(request);
    }
}