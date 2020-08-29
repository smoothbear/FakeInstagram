package com.kjbin0420.fakeinstagram.Service.board;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
    public void addCommentService(HttpServletRequest request, String comment, Integer boardNum);
    public void addPictureService(HttpServletRequest request, Integer boardNum)
}
