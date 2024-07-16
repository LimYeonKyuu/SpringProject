package com.example.springproject2.board.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AddBoardRequest {
    private String title;
    private String content;
}
