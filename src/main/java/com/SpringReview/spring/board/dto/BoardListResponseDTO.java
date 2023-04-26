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
    private final String shortTitle;
    private final String shortContent;
    private final int viewCount;
    private final String date;

    public BoardListResponseDTO(Board board) {
        this.boardNo = board.getBoardNo();
        this.shortTitle = makeShortTitle(board.getTitle());
        this.shortContent = makeShortContent(board.getContent());
        this.date = makePrettierDateString(board.getRegDateTime());
        this.viewCount = board.getViewCount();
    }

    private String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

    private String makeShortContent(String content) {
        return (content.length() > 35) ? content.substring(0, 32)+"..." : content;
    }

    private String makeShortTitle(String title) {
        return (title.length() > 10) ? title.substring(0, 10) : title;
    }


}


