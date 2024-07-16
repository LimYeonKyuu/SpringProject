package com.example.springproject2.board.controller.response;

import com.example.springproject2.board.controller.dto.BoardDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDetailResponse {
    private Long id;
    private String title;
    private String content;

    public static BoardDetailResponse from(BoardDto dto){
        return BoardDetailResponse.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }
}
