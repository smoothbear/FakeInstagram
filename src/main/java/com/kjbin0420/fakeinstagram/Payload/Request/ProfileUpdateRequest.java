package com.kjbin0420.fakeinstagram.Payload.Request;

import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
public class ProfileUpdateRequest {
    String userName;
    String userPw;

    @Email
    String userEmail;
}
