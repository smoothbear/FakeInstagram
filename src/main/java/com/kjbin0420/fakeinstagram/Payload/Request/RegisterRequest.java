package com.kjbin0420.fakeinstagram.Payload.Request;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import java.util.Optional;

@Getter
public class RegisterRequest {
    String userId;
    String userPw;
    String userName;
    MultipartFile profileImage;

    @Email
    String userEmail;
}