package com.example.springproject2.board.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    public static Board from(String title, String content) {
        Board board = new Board();
        board.title = title;
        board.content = content;
        return board;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
