package com.SpringReview.spring.board.controller;

import com.SpringReview.spring.board.dto.BoardListResponseDTO;
import com.SpringReview.spring.board.dto.BoardRequestDto;
import com.SpringReview.spring.board.entity.Board;
import com.SpringReview.spring.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("/board/list : GET");
        List<BoardListResponseDTO> blist = boardService.getList();
        model.addAttribute("blist", blist);
        return "list";
    }

    @GetMapping("/detail")
    public String detail(int boardNo, Model model) {
        System.out.println("/board/detail/ GET발생");
        Board bDetail = boardService.getOneList(boardNo);
        model.addAttribute("b",bDetail);
        return "detail";
    }


    @GetMapping("/modify")
    public String modify(int boardNo, Model model){
        Board oneList = boardService.getOneList(boardNo);
        model.addAttribute("b",oneList);
        return "modify";
    }
    @PostMapping("/modify")
    public String modify(BoardRequestDto dto, int boardNo){
        Board oneList = boardService.getOneList(boardNo);
        oneList.setTitle(dto.getTitle());
        oneList.setContent(dto.getContent());
        boardService.updateOne(oneList);
        System.out.println("oneList = " + oneList);
        return "redirect:/board/detail?boardNo="+boardNo;
    };

    @GetMapping("/save")
    public String goSavePage(){
        System.out.println("get발생");
        return "save";
    }
    @PostMapping("/save")
    public String save(Board board){
        System.out.println("post맵핑 발생");
        System.out.println("board = " + board);
        boardService.save(board);
        return "redirect:/board/list";
    }

}
