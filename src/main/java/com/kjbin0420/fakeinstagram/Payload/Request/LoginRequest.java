package com.kjbin0420.fakeinstagram.Payload.Request;

import lombok.Getter;

@Getter
public class LoginRequest {
    String userId;
    String userPw;
}