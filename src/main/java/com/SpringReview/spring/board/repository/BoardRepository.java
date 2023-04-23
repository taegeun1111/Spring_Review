package com.SpringReview.spring.board.repository;

import com.SpringReview.spring.board.entity.Board;

import java.util.List;

public interface BoardRepository {

    List<Board> findAll();

    Board findOne(int boardNo);

    boolean save(Board board);

    boolean deleteByNo(int boardNo);
}
