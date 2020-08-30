package com.kjbin0420.fakeinstagram.Payload.Request;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
public class BoardAddRequest {
    String userId;
    String title;
    String bodyText;

    List<MultipartFile> picture;
}
