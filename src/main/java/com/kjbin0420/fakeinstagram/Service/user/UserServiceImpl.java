package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Entity.User.Following;
import com.kjbin0420.fakeinstagram.Entity.User.UserData;
import com.kjbin0420.fakeinstagram.Exceptions.FileStorageException;
import com.kjbin0420.fakeinstagram.Exceptions.UserNotFoundException;
import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import com.kjbin0420.fakeinstagram.Repository.User.FollowingRepository;
import com.kjbin0420.fakeinstagram.Repository.User.UserRepository;
import com.kjbin0420.fakeinstagram.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FollowingRepository followingRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${profile.save.auth}")
    private String uploadPath;

    public String getUserFilePath(String userId) {
        return userRepository.findByUserId(userId)
                .map(UserData::getImagePath)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public String userProfileImageUpload(MultipartFile file, String userId) {
        Path location = Paths.get(uploadPath + userId);
        try {
            Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
            return location.getFileName().toString();
        } catch (IOException e) {
            throw new FileStorageException(file.getOriginalFilename());
        }
    }

    @Override
    public void userProfileService(String userId) {
    }

    @Override
    public boolean userRegisterService(RegisterRequest request){
        Optional<UserData> userData = userRepository.findByUserId(request.getUserId());
        if (userData.isEmpty()) {
            if (request.getProfileImage() != null) {
                userRepository.save(
                        UserData.builder()
                                .imagePath(userProfileImageUpload(request.getProfileImage(), request.getUserId()))
                                .userId(request.getUserId())
                                .userPw(request.getUserPw())
                                .userEmail(request.getUserEmail())
                                .userName(request.getUserName())
                                .build()
                );
            }
            else {
                userRepository.save(
                        UserData.builder()
                        .userId(request.getUserId())
                        .userPw(request.getUserPw())
                        .userEmail(request.getUserEmail())
                        .userName(request.getUserName())
                        .build()
                );
            }
            return true;
        }
        else
            return false;
    }

    @Override
    public void userFollowingService(String targetId, HttpServletRequest request) {
        String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
        followingRepository.save(
                Following.builder()
                    .targetUserId(targetId)
                    .userId(userId)
                    .targetUserProfilePath(getUserFilePath(targetId))
                    .build()
        );
    }

    @Override
    public List<Following> userFollowingList(HttpServletRequest request) {
        String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
        return followingRepository.findAllByUserId(userId);
    }
}