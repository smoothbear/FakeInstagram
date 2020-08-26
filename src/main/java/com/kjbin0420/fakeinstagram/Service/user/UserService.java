package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Entity.User.Follower;
import com.kjbin0420.fakeinstagram.Entity.User.Following;
import com.kjbin0420.fakeinstagram.Payload.Request.ProfileUpdateRequest;
import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    public String getUserFilePath(String userId);
    public void userProfileService(String userId);
    public void profileImageUploadService(MultipartFile file, String userId);
    public boolean userFollowingService(String targetId, HttpServletRequest request);
    public List<Following> getUserFollowingService(HttpServletRequest request);
    public List<Follower> getUserFollowerService(HttpServletRequest request);
    public boolean userProfileUpdateService(HttpServletRequest request, ProfileUpdateRequest updateRequest);
    public void userRegisterService(RegisterRequest request);
}