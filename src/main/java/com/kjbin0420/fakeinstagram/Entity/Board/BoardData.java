package com.kjbin0420.fakeinstagram.Entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Builder @AllArgsConstructor
public class BoardData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UUID;

    @Column(updatable = true, nullable = false)
    private String boardTitle;

    @Column(nullable = false)
    private Integer viewNum;

    @Column(updatable = true, nullable = false)
    private String boardText;

    @ManyToOne
    private PicturePath picturePath;

    @ManyToOne
    private BoardComment boardComment;
}