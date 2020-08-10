package com.kjbin0420.fakeinstagram.Service.auth;

import com.kjbin0420.fakeinstagram.Entity.Token.RefreshToken;
import com.kjbin0420.fakeinstagram.Entity.User.UserData;
import com.kjbin0420.fakeinstagram.Exceptions.ExpiredTokenException;
import com.kjbin0420.fakeinstagram.Exceptions.InvalidTokenException;
import com.kjbin0420.fakeinstagram.Exceptions.UserNotFoundException;
import com.kjbin0420.fakeinstagram.Payload.Request.LoginRequest;
import com.kjbin0420.fakeinstagram.Payload.Response.TokenResponse;
import com.kjbin0420.fakeinstagram.Repository.Token.RefreshTokenRepository;
import com.kjbin0420.fakeinstagram.Repository.User.UserRepository;
import com.kjbin0420.fakeinstagram.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Value("${auth.jwt.exp.refresh}")
    private Long refreshExp;

    @Value("${auth.jwt.prefix}")
    private String tokenType;

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TokenResponse signIn(LoginRequest request) {
        return userRepository.findByUserId(request.getUserId())
                .filter(userData -> request.getUserPw().equals(userData.getUserPw()))
                    .map(UserData::getUserId)
                    .map(userId -> {
                        String refreshToken = jwtTokenProvider.generateRefreshToken(userId);
                        refreshTokenRepository.save(
                                RefreshToken.builder()
                                    .userId(userId)
                                    .refreshToken(refreshToken)
                                    .ttl(refreshExp)
                                    .build()
                        );
                        return new RefreshToken(userId, refreshToken, refreshExp);
                    })
                    .map(refreshToken -> {
                        String accessToken = jwtTokenProvider.generateAccessToken(refreshToken.getUserId());
                        return new TokenResponse(accessToken, refreshToken.getRefreshToken(), tokenType);
                    })
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public TokenResponse refreshToken(String receivedToken) {
        if (!jwtTokenProvider.isRefreshToken(receivedToken))
            throw new InvalidTokenException();

        return refreshTokenRepository.findByRefreshToken(receivedToken)
                .map(refreshToken -> {
                    String generatedRefreshToken = jwtTokenProvider.generateRefreshToken(refreshToken.getUserId());
                    return refreshToken.update(generatedRefreshToken, refreshExp);
                })
                .map(refreshTokenRepository::save)
                .map(refreshToken -> {
                    String generatedAccessToken = jwtTokenProvider.generateAccessToken(refreshToken.getUserId());
                    return new TokenResponse(generatedAccessToken, refreshToken.getRefreshToken(), tokenType);
                })
                .orElseThrow(ExpiredTokenException::new);
    }
}