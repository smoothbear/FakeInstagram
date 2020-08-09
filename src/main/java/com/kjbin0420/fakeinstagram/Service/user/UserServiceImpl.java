package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Entity.User.UserData;
import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import com.kjbin0420.fakeinstagram.Repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void userProfileService(String userId) {
    }

    @Override
    public boolean userRegisterService(RegisterRequest request){
        Optional<UserData> userData = userRepository.findByUserId(request.getUserId());
        if (userData.isEmpty()) {
            userRepository.save(
                    UserData.builder()
                            .userId(request.getUserId())
                            .userPw(request.getUserPw())
                            .userEmail(request.getUserEmail())
                            .userName(request.getUserName())
                            .build()
            );
            return true;
        }
        else
            return false;
    }
}