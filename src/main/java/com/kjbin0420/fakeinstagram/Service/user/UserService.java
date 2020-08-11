package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Entity.User.Following;
import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    public void userProfileService(String userId);
    public String userProfileImageUpload(MultipartFile file, String userId);
    public boolean userRegisterService(RegisterRequest request);
    public void userFollowingService(String targetId, HttpServletRequest request);
    public List<Following> userFollowingList(HttpServletRequest request);
}