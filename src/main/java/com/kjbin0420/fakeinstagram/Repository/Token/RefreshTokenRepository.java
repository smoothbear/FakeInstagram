package com.kjbin0420.fakeinstagram.Repository.Token;

import com.kjbin0420.fakeinstagram.Entity.Token.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}