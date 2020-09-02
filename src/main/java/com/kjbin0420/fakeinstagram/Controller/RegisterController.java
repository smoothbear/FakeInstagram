package com.kjbin0420.fakeinstagram.Controller;

import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import com.kjbin0420.fakeinstagram.Service.user.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @GetMapping("/checkRegistered")
    public boolean checkRegistered(String userId) {
        return registerService.isAlreadyRegisteredService(userId);
    }

    @PostMapping("/register")
    public boolean userRegister(@RequestBody RegisterRequest request) {
        return registerService.userRegisterService(request);
    }
}
