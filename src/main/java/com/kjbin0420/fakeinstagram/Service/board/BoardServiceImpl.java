package com.kjbin0420.fakeinstagram.Service.board;

import com.kjbin0420.fakeinstagram.Entity.Board.BoardComment;
import com.kjbin0420.fakeinstagram.Entity.Board.BoardData;
import com.kjbin0420.fakeinstagram.Exceptions.BoardNotFoundException;
import com.kjbin0420.fakeinstagram.Repository.Board.BoardCommentRepository;
import com.kjbin0420.fakeinstagram.Repository.Board.BoardRepository;
import com.kjbin0420.fakeinstagram.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;
    private BoardCommentRepository commentRepository;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void addCommentService(HttpServletRequest request, String comment, Integer boardNum) {
        String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));

        BoardData data = boardRepository.findById(boardNum)
                .map(boardData -> {
                        boardData.addComment(
                                BoardComment.builder()
                                        .writerId(userId)
                                        .commentContext(comment)
                                        .build()
                        );
                        boardRepository.save(boardData);
                        return boardData;
                    })
                    .orElseThrow(BoardNotFoundException::new);
    }

    @Override
    public void addPictureService(HttpServletRequest request, Integer boardNum) {

    }
}
