package com.SpringReview.spring.board.controller;

import com.SpringReview.spring.board.dto.BoardListResponseDTO;
import com.SpringReview.spring.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @RequestMapping("/list")
    public String list(Model model){
        System.out.println("/board/list : GET");
        List<BoardListResponseDTO> blist = boardService.getList();
        model.addAttribute("blist",blist);
        return "list";
    }
}
