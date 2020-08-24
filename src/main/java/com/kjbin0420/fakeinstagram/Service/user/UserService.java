package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Entity.User.Following;
import com.kjbin0420.fakeinstagram.Payload.Request.ProfileUpdateRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    public String getUserFilePath(String userId);
    public void userProfileService(String userId);
    public void profileImageUploadService(MultipartFile file, String userId);
    public void userFollowingService(String targetId, HttpServletRequest request);
    public List<Following> getUserFollowingService(HttpServletRequest request);
    public boolean userProfileUpdateService(HttpServletRequest request, ProfileUpdateRequest updateRequest);
}