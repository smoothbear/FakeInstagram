package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import org.springframework.web.multipart.MultipartFile;

public interface RegisterService {
    public boolean userRegisterService(RegisterRequest request);
    public String profileImageUploadService(MultipartFile file, String userId);
}
