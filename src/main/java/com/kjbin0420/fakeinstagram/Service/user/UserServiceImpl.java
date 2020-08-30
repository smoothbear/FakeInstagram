package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Entity.User.Follower;
import com.kjbin0420.fakeinstagram.Entity.User.Following;
import com.kjbin0420.fakeinstagram.Entity.User.UserData;
import com.kjbin0420.fakeinstagram.Exceptions.FileStorageException;
import com.kjbin0420.fakeinstagram.Exceptions.UserAlreadyRegisteredException;
import com.kjbin0420.fakeinstagram.Exceptions.UserNotFoundException;
import com.kjbin0420.fakeinstagram.Payload.Request.ProfileUpdateRequest;
import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import com.kjbin0420.fakeinstagram.Repository.User.FollowerRepository;
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
    private final FollowerRepository followerRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${profile.save.path}")
    private String uploadPath;

    public String getUserFilePath(String userId) {
        return userRepository.findByUserId(userId)
                .map(UserData::getImagePath)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void profileImageUploadService(MultipartFile file, String userId) {
        Path location = Paths.get(uploadPath + userId);
        try {
            Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new FileStorageException(file.getOriginalFilename());
        }
    }

    @Override
    public void userProfileService(String userId) {
    }

    @Override
    public boolean userFollowingService(String targetId, HttpServletRequest request) {
        final String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
        userRepository.findByUserId(userId)
                .map(userData -> {
                    followingRepository.save(
                            Following.builder()
                                    .targetUserId(targetId)
                                    .userId(userId)
                                    .targetUserProfilePath(getUserFilePath(targetId))
                                    .build()
                    );
                    followerRepository.save(
                            Follower.builder()
                                .userUUID(userData.getUUID())
                                .userId(targetId)
                                .build()
                    );
                    return true;
                })
                .orElseThrow(UserNotFoundException::new);
        return false;
    }

    @Override
    public List<Following> getUserFollowingService(HttpServletRequest request) {
        final String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
        return followingRepository.findAllByUserId(userId);
    }

    @Override
    public boolean userProfileUpdateService(HttpServletRequest request, ProfileUpdateRequest updateRequest) {
        final String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
        profileImageUploadService(updateRequest.getProfileImage(), userId);
        return userRepository.findByUserId(userId)
                .map(userData -> {
                    userData.setUserName(updateRequest.getUserName());
                    userData.setUserPw(updateRequest.getUserPw());
                    userData.setUserEmail(updateRequest.getUserEmail());
                    userRepository.userProfileUpdate(userData);
                    return true;
                })
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void userRegisterService(RegisterRequest request) {
        Optional<UserData> userData = userRepository.findByUserId(request.getUserId());
        if (userData.isEmpty() && request.isEmailIdentified()) {
            userRepository.save(
                    UserData.builder()
                    .userName(request.getUserName())
                    .userEmail(request.getUserEmail())
                    .userId(request.getUserId())
                    .userPw(request.getUserPw())
                    .build()
            );
        }
        else
            throw new UserAlreadyRegisteredException();
    }

    @Override
    public List<Follower> getUserFollowerService(HttpServletRequest request) {
        String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
        return followerRepository.findAllByUserId(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}