package com.SpringReview.spring.board.repository;

import com.SpringReview.spring.board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Board> findAll(){
        String sql = "SELECT * FROM board";
        List<Board> boardList = jdbcTemplate.query(sql, (rs, rowNum) -> new Board(rs));
        return boardList.stream()
                .sorted(Comparator.comparing(s->s.getBoardNo()))
                .collect(Collectors.toList());
    }

    @Override
    public Board findOne(int boardNo) {
        String sql = "SELECT * FROM board WHERE board_no=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Board(rs), boardNo);
    }



    @Override
    public boolean save(Board board) {
        String sql = "INSERT INTO board(title,content,view_count,reg_datetime) VALUES(?,?,?,?)";
        int result = jdbcTemplate.update(sql, board.getTitle(), board.getContent(),
                board.getViewCount(), board.getRegDateTime());
        if (result==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByNo(int boardNo) {
        String sql = "DELETE FROM board WHERE board_no=?";
        int result = jdbcTemplate.update(sql, boardNo);
        if (result ==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean modify(Board board) {
        String sql = "UPDATE board SET title=?,content=? WHERE board_no=?";
        int result = jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getBoardNo());
        return result == 1;
    }
}
