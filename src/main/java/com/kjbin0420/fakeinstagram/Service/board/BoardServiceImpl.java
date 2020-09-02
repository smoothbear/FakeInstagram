package com.kjbin0420.fakeinstagram.Service.board;

import com.kjbin0420.fakeinstagram.Entity.Board.BoardComment;
import com.kjbin0420.fakeinstagram.Entity.Board.BoardData;
import com.kjbin0420.fakeinstagram.Entity.Board.PicturePath;
import com.kjbin0420.fakeinstagram.Exceptions.BoardNotFoundException;
import com.kjbin0420.fakeinstagram.Exceptions.FileStorageException;
import com.kjbin0420.fakeinstagram.Payload.Request.BoardAddRequest;
import com.kjbin0420.fakeinstagram.Repository.Board.BoardCommentRepository;
import com.kjbin0420.fakeinstagram.Repository.Board.BoardRepository;
import com.kjbin0420.fakeinstagram.Security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardCommentRepository commentRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${board.image.path}")
    private final String imageBasicPath;

    private void uploadPictureService(List<MultipartFile> image, String imagePath, BoardData boardData) {
        int num = 1;
        String numString;
        try {
            for (MultipartFile file : image) {
                numString = Integer.toString(num);
                Path location = Paths.get(imagePath + "/" + numString);
                Files.copy(file.getInputStream(), location, StandardCopyOption.REPLACE_EXISTING);
                boardData.addPicturePath(
                        PicturePath.builder()
                                .picturePath(imagePath + "/" + numString)
                                .build()
                );
                num++;
            }
        } catch (IOException e) {
            throw new FileStorageException();
        }
    }

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
    public void addBoardService(HttpServletRequest request, BoardAddRequest boardRequest) {
        final String userId = jwtTokenProvider.getUserId(jwtTokenProvider.resolveToken(request));
        BoardData boardData = boardRepository.save(
                BoardData.builder()
                    .writer(userId)
                    .boardTitle(boardRequest.getTitle())
                    .boardText(boardRequest.getBodyText())
                    .build()
        );

        Integer boardNum = boardData.getUUID();
        final String imagePath = imageBasicPath + boardNum.toString();

        List<MultipartFile> picture = boardRequest.getPicture();
        this.uploadPictureService(picture, imagePath, boardData);
    }
}
