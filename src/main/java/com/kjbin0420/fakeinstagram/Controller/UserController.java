package com.kjbin0420.fakeinstagram.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private CustomUserDetailsService customUserDetailsService;
    @PostMapping("/{userId}")
    public UserPage userProfile(@PathVariable String userId) {

    }
}