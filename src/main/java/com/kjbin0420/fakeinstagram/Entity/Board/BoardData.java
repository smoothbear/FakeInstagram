package com.kjbin0420.fakeinstagram.Entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Builder @AllArgsConstructor
public class BoardData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Integer UUID;

    @Column
    private String writer;

    @Column(updatable = true, nullable = false)
    private String boardTitle;

    @Column(nullable = false)
    private Integer viewNum;

    @Column(updatable = true, nullable = false)
    private String boardText;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private final Date writeDate = new Date();

    @OneToMany
    @JoinColumn(name = "picturepath_id")
    private Set<PicturePath> picturePath;

    @OneToMany
    @JoinColumn(name = "boardcomment_id")
    private List<BoardComment> boardComment;

    public void addComment(BoardComment comment) {
        this.boardComment.add(comment);
    }

    public void addPicturePath(PicturePath picturePath) {
        this.picturePath.add(picturePath);
    }

    public Integer getUUID() {
        return this.UUID;
    }
}