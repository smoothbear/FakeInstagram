package com.kjbin0420.fakeinstagram.Entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Builder @AllArgsConstructor
public class BoardComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UUID;

    @Column(updatable = false, nullable = false)
    private String commentWriter;

    @Column(nullable = false)
    private String commentContext;

    @ManyToOne
    private BoardCommentReply commentReply;
}
