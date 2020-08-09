package com.kjbin0420.fakeinstagram.Controller;

import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import com.kjbin0420.fakeinstagram.Service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /*
    @PostMapping("/{userId}")
    public UserPage userProfile(@PathVariable String userId) {

    }
    */
    @GetMapping("/following/{targetId}")
    public void userFollowing(@PathVariable String targetId) {

    }

    @PostMapping("/register")
    public boolean userRegister(@RequestBody RegisterRequest request) {
        return userService.userRegisterService(request);
    }
}