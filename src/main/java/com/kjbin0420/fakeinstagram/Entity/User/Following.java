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

    @Column(nullable = false)
    private String targetUserId;
    private String userId;
}