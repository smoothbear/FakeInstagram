package com.kjbin0420.fakeinstagram.Controller;

import com.kjbin0420.fakeinstagram.Service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
