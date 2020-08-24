package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Entity.User.UserData;
import com.kjbin0420.fakeinstagram.Exceptions.FileStorageException;
import com.kjbin0420.fakeinstagram.Exceptions.UserAlreadyRegisteredException;
import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import com.kjbin0420.fakeinstagram.Repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;

    @Value("${profile.save.path}")
    private String uploadPath;

    @Override
    public String profileImageUploadService(MultipartFile file, String userId) {
        Path location = Paths.get(uploadPath + userId);
        try {
            Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
            return location.getFileName().toString();
        } catch (IOException e) {
            throw new FileStorageException(file.getOriginalFilename());
        }
    }

    @Override
    public boolean userRegisterService(RegisterRequest request){
        Optional<UserData> userData = userRepository.findByUserId(request.getUserId());
        if (userData.isEmpty()) {
            if (request.getProfileImage() != null) {
                userRepository.save(
                        UserData.builder()
                                .imagePath(this.profileImageUploadService(request.getProfileImage(), request.getUserId()))
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
            throw new UserAlreadyRegisteredException();
    }
}
