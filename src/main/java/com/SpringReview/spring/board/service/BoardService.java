package com.SpringReview.spring.board.service;

import com.SpringReview.spring.board.dto.BoardListResponseDTO;
import com.SpringReview.spring.board.entity.Board;
import com.SpringReview.spring.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class BoardService {
    private final BoardRepository boardRepository;


    public List<BoardListResponseDTO> getList(){
        List<Board> board = boardRepository.findAll();
        return board.stream()
                .map(board1 -> new BoardListResponseDTO(board1))
                .collect(Collectors.toList());
    }


}
