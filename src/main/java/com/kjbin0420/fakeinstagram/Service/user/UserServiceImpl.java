package com.kjbin0420.fakeinstagram.Service.user;

import com.kjbin0420.fakeinstagram.Repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void userProfileService(String userId) {
    }

    @Override
    public void userLogin() {

    }
}