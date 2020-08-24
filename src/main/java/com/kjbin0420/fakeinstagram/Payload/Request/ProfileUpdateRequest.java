package com.kjbin0420.fakeinstagram.Payload.Request;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;

@Getter
public class ProfileUpdateRequest {
    String userName;
    String userPw;

    @Email
    String userEmail;

    MultipartFile profileImage;
}
