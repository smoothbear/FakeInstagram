package com.kjbin0420.fakeinstagram.Entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Builder
public class BoardCommentReply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UUID;

    @Column(updatable = false, nullable = false)
    private String writerId;

    @Column(nullable = false)
    private String commentContext;
}
