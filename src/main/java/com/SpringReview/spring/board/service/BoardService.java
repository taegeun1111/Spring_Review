package com.SpringReview.spring.board.service;

import com.SpringReview.spring.board.dto.BoardListResponseDTO;
import com.SpringReview.spring.board.dto.BoardRequestDto;
import com.SpringReview.spring.board.entity.Board;
import com.SpringReview.spring.board.repository.BoardMapper;
import com.SpringReview.spring.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
//    private final BoardRepository boardRepository;
    private final BoardMapper boardRepository;


    public boolean save(Board board){
        board.setRegDateTime(LocalDateTime.now());
        return boardRepository.save(board);
    }

    public List<BoardListResponseDTO> getList(){
        List<Board> board = boardRepository.findAll();
        return board.stream()
                .map(board1 -> new BoardListResponseDTO(board1))
                .collect(Collectors.toList());
    }

    public Board getOneList(int boardNo){
        boardRepository.viewCount(boardNo);
        return boardRepository.findOne(boardNo);
    }

    public boolean updateOne(Board board){
        return boardRepository.modify(board);
    }


}
