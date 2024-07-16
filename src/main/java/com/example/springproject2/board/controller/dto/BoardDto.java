package com.example.springproject2.board.controller.dto;

import com.example.springproject2.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardDto {
    private Long id;
    private String title;
    private String content;

    public static BoardDto from(Board board) {
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
