package com.kjbin0420.fakeinstagram.Service.auth;

import com.kjbin0420.fakeinstagram.Entity.User.UserData;
import com.kjbin0420.fakeinstagram.Repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserData userData = userRepository.findByUserId(userId);
        if (userData != null)
            return new AuthDetails(userData.getUserId(), userData.getUserPw());
        else
            throw new UsernameNotFoundException(userId);
    }
}