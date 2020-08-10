package com.kjbin0420.fakeinstagram.Entity.Token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @AllArgsConstructor @NoArgsConstructor @Builder
public class RefreshToken {
    @Id
    private String userId;

    @Column
    private String refreshToken;
    private Long ttl;

    public RefreshToken update(String refreshToken, Long ttl) {
        this.refreshToken = refreshToken;
        this.ttl = ttl;
        return this;
    }
}