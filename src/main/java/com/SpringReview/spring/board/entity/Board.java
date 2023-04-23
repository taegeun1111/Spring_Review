package com.SpringReview.spring.board.entity;

import lombok.*;

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
}
