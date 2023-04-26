package com.SpringReview.spring.board.repository;

import com.SpringReview.spring.board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryImplTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void saveTest(){
        //given
        Board b = new Board();
        b.setTitle("아무나");
        b.setContent("이부진 호텔신라 대표이사 사장이 퇴임했던 임원을 자회사 대표로 다시 불러들였다.이강일 SBTM 대표이사가 그 주인공이다. SBTM은 항공 및 철도 발권, 호텔..");
        b.setRegDateTime(LocalDateTime.now());

        //when
        boolean flag = boardRepository.save(b);
        //then
        assertTrue(flag);
        //데이트타입을 -> 로컬 데이트 타입으로 변환
    }

    @Test
    void removeTest(){
        int boardNo = 3;
        boolean flag = boardRepository.deleteByNo(boardNo);

        assertTrue(flag);
    }

    @Test
    void findAllTest(){

        List<Board> all = boardRepository.findAll();
        for (Board board : all) {
            System.out.println("board = " + board);
        }
    }


    @Test
    void findOneTest(){
        int board = 4;
        Board one = boardRepository.findOne(board);
        System.out.println("one = " + one);
    }

    @Test
    void modifyTest(){
        Board b = new Board();
        b.setBoardNo(2);
        b.setTitle("수정타이틀");
        b.setContent("위의 코드에서 Person 객체를 생성한 후, 해당 객체의 id, personName, personAge 필드를 수정한 후, modifyPerson 메서드를 호출합니다.");

        boolean modify = boardRepository.modify(b);
        assertTrue(modify);
    }
}