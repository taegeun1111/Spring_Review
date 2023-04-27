package com.SpringReview.spring.board.repository;

import com.SpringReview.spring.board.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> findAll();

    Board findOne(int boardNo);

    boolean save(Board board);

    boolean deleteByNo(int boardNo);

    boolean modify(Board board);
}
