package com.kjbin0420.fakeinstagram.Repository.Board;

import com.kjbin0420.fakeinstagram.Entity.Board.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommentRepository extends JpaRepository<Integer, BoardComment> {
}
