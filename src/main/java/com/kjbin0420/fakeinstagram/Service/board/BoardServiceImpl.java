package com.kjbin0420.fakeinstagram.Service.board;

import com.kjbin0420.fakeinstagram.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;
    
}
