package com.SpringReview.spring.board.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardRequestDto {
    private int boardNo;
    private String title;
    private String content;
}
