package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Entity.User.Following;
import com.kjbin0420.fakeinstagram.Entity.User.UserData;
import com.kjbin0420.fakeinstagram.Payload.Request.RegisterRequest;
import com.kjbin0420.fakeinstagram.Repository.User.FollowingRepository;
import com.kjbin0420.fakeinstagram.Repository.User.UserRepository;
import com.kjbin0420.fakeinstagram.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FollowingRepository followingRepository;
    private final JwtTokenProvider jwtTokenProvider;

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

    @Override
    public void userFollowingService(String targetId, HttpServletRequest request) {
        String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
        followingRepository.save(
                Following.builder()
                    .targetUserId(targetId)
                    .userId(userId)
                    .build()
        );
    }

    @Override
    public List<Following> userFollowingList(HttpServletRequest request) {
        String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
        return followingRepository.findAllByUserId(userId);
    }
}