package com.kjbin0420.fakeinstagram.Service.board;

import com.kjbin0420.fakeinstagram.Repository.BoardRepository;
import com.kjbin0420.fakeinstagram.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void addCommentService(HttpServletRequest request, String comment) {
        String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
    }
}
