package com.kjbin0420.fakeinstagram.Entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor @Builder @Getter
public class Follower {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UUID;

    @Column(nullable = false, unique = true)
    private Integer userUUID;
    private String userId;
}