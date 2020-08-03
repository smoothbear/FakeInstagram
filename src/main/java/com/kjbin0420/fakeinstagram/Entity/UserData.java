package com.kjbin0420.fakeinstagram.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table @NoArgsConstructor @Getter
@Builder
public class UserData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UUID;

    @Column(nullable = false, unique = true)
    private String userId;
    private String userEmail;

    @Column(nullable = false)
    private String userPw;
    private String userName;
}