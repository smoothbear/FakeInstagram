package com.kjbin0420.fakeinstagram.Service;

import com.kjbin0420.fakeinstagram.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetails {
    private UserRepository userRepository;
    private Authenti
}
