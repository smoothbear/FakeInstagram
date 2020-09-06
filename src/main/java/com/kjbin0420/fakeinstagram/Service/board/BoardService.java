package com.kjbin0420.fakeinstagram.Service.board;

import com.kjbin0420.fakeinstagram.Payload.Request.BoardAddRequest;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
    public void addCommentService(HttpServletRequest request, String comment, Integer boardNum);
    public void addBoardService(HttpServletRequest request, BoardAddRequest boardRequest);
    public void plusViewNumService(Integer boardId);
}
