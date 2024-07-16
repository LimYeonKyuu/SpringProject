package com.example.springproject2.board.controller.response;

import com.example.springproject2.board.controller.dto.BoardDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class BoardListResponse {
    private List<Board> boards;
    public static BoardListResponse from(List<BoardDto> dtos) {
        return BoardListResponse.builder()
                .boards(dtos.stream()
                        .map(Board::from)
                        .collect(Collectors.toList()))
                .build();
    }

    @Getter
    @Builder
    private static class Board{
        private Long id;
        private String title;

        public static Board from(BoardDto boardDto) {
            return Board.builder()
                    .id(boardDto.getId())
                    .title(boardDto.getTitle())
                    .build();
        }
    }
}
