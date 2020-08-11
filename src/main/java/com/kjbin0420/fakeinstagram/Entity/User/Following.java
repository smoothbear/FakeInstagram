package com.kjbin0420.fakeinstagram.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Table @AllArgsConstructor
@NoArgsConstructor @Getter @Builder
public class Following {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UUID;

    @Column(nullable = false, unique = true)
    private String targetUserId;

    @Column(nullable = false)
    private String userId;

    @Column
    private String targetUserProfilePath;
}