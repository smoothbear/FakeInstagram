package com.kjbin0420.fakeinstagram.Entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Table
@NoArgsConstructor @Getter @Builder
public class Following {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UUID;

    @Column(nullable = false)
    private Integer userUUID;
    private String userId;
}