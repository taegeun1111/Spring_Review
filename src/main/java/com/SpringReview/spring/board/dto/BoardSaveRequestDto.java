package com.SpringReview.spring.board.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class BoardSaveRequestDto {
    private String title;
    private String content;
}
