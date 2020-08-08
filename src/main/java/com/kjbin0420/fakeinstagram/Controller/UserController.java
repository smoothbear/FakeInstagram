package com.kjbin0420.fakeinstagram.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @PostMapping("/{userId}")
    public UserPage userProfile(@PathVariable String userId) {

    }

    @GetMapping("/following/{targetId}")
    public void userFollowing(@PathVariable String targetId) {

    }
}