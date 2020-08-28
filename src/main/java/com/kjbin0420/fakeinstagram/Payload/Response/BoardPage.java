package com.kjbin0420.fakeinstagram.Payload.Response;

import com.kjbin0420.fakeinstagram.Entity.Board.BoardData;

import java.io.Serializable;

public class BoardPage implements Serializable {
    private static final long serialVersionUID = 5290440163078604473L;

    String title;
    String userId;

    BoardData boardData;
}
