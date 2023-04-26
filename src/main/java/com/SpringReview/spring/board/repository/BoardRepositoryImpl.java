package com.SpringReview.spring.board.repository;

import com.SpringReview.spring.board.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
    private final static Map<Integer, Board> boardMap;
    private static int sequence;

    static {
        boardMap = new HashMap<>();
        Board b1 = new Board(++sequence, "돈까스 레시피", "그냥 이마트에서 사서 에어프라이 돌려라~");
        Board b2 = new Board(++sequence, "관종의 조건", "이 세상은 나를 중심으로 돌아간다라는 마음으로 행동해라ㅋㅋ");
        Board b3 = new Board(++sequence, "이마트 영업시간", "10시에 마감하는걸로 바뀌었나요?? 마감털이 몇시에 가야되죠?? 하.....");
        Board b4 = new Board(++sequence, "이마트 영업시간", "10시에 마감하는걸로 바뀌었나요?? 마감털이 몇시에 가야되죠?? 하.....");

        boardMap.put(b1.getBoardNo(), b1);
        boardMap.put(b2.getBoardNo(), b2);
        boardMap.put(b3.getBoardNo(), b3);
        boardMap.put(b4.getBoardNo(), b4);
    }


    @Override
    public List<Board> findAll(){
        return boardMap.values()
                .stream()
                .sorted(Comparator.comparing(s->s.getBoardNo()))
                .collect(Collectors.toList());
    }

    @Override
    public Board findOne(int boardNo) {
        return null;
    }

    @Override
    public boolean save(Board board) {
        return false;
    }

    @Override
    public boolean deleteByNo(int boardNo) {
        return false;
    }
}
