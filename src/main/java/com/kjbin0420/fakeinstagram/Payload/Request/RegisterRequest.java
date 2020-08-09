package com.kjbin0420.fakeinstagram.Payload.Request;

import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
public class RegisterRequest {
    String userId;
    String userPw;
    String userName;

    @Email
    String userEmail;
}