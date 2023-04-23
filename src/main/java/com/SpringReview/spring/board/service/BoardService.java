package com.SpringReview.spring.board.service;

import com.SpringReview.spring.board.entity.Board;
import com.SpringReview.spring.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardService {
    private final BoardRepository boardRepository;


    public void getList(){
        boardRepository.findAll()
    }
}
