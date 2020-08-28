package com.kjbin0420.fakeinstagram.Entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder @AllArgsConstructor
public class BoardComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardcomment_id")
    private Integer UUID;

    @Column(updatable = false, nullable = false)
    private String writerId;

    @Column(nullable = false)
    private String commentContext;

    @OneToMany
    private List<CommentReply> commentReply;
}
