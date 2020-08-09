package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;

public interface UserService {
    public void userProfileService(String userId);
    public boolean userRegisterService(RegisterRequest request);
}