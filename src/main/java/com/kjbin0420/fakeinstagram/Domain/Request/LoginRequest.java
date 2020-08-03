package com.kjbin0420.fakeinstagram.Domain.Request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {
    String userId;
    String userPw;
}
