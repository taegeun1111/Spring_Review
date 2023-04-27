package com.SpringReview.spring.board.entity;

import com.SpringReview.spring.board.dto.BoardRequestDto;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Setter @Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int boardNo;
    private String title;
    private String content;
    private int viewCount;
    private LocalDateTime regDateTime;

    public Board(int boardNo, String title, String content) {
        this.boardNo = boardNo;
        this.title = title;
        this.content = content;
        this.regDateTime = LocalDateTime.now();
    }

    //등록하기 위한 생성자
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
        this.regDateTime = LocalDateTime.now();
    }


    public Board(ResultSet rs) throws SQLException {
        this.boardNo = rs.getInt("board_no");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
        this.regDateTime = rs.getTimestamp("reg_datetime").toLocalDateTime();
    }

}
