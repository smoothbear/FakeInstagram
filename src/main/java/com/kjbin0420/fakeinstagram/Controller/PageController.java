package com.kjbin0420.fakeinstagram.Controller;

import com.kjbin0420.fakeinstagram.Payload.Request.BoardAddRequest;
import com.kjbin0420.fakeinstagram.Service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class PageController {
    private final BoardService boardService;

    @GetMapping("/{boardNum}")
    public void addComment(@PathVariable Integer boardNum, HttpServletRequest request, String comment) {
        boardService.addCommentService(request, comment, boardNum);
    }

    @PostMapping("/addPicture")
    public void addPicture(HttpServletRequest request, BoardAddRequest boardRequest) {
        boardService.addBoardService(request, boardRequest);
    }
}
