package com.kjbin0420.fakeinstagram.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @Builder @NoArgsConstructor
public class EmailAuthNum {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer num;

    LocalDateTime createdAt;
}
