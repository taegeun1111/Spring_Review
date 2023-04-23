package com.SpringReview.spring.board.dto;

import com.SpringReview.spring.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@EqualsAndHashCode
@ToString
public class BoardListResponseDTO {
    private final int boardNo;
    private final String title;
    private final String content;
    private final int viewCount;
    private final String regDateTime;

    public BoardListResponseDTO(Board board) {
        this.boardNo = board.getBoardNo();
        this.title = makeShortTitle(board.getTitle());
        this.content = makeShortContent(board.getContent());
        this.regDateTime = makePrettierDateString(board.getRegDateTime());
        this.viewCount = board.getViewCount();
    }

    private String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

    private String makeShortContent(String content) {

        return null;
    }

    private String makeShortTitle(String title) {
    }


}


