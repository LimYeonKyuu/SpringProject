package com.example.springproject2.board.controller;

import com.example.springproject2.board.controller.request.AddBoardRequest;
import com.example.springproject2.board.controller.response.BoardDetailResponse;
import com.example.springproject2.board.controller.response.BoardListResponse;
import com.example.springproject2.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;


    @PostMapping("/api/boards")
    public ResponseEntity<Void> createBoard(@RequestBody AddBoardRequest request) {
        boardService.createBoard(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/boards")
    public ResponseEntity<BoardListResponse> getBoards() {
        return ResponseEntity.ok(BoardListResponse.from(boardService.getBoards()));
    }

    @GetMapping("/api/boards/{id}")
    public ResponseEntity<BoardDetailResponse> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(BoardDetailResponse.from(boardService.getBoard(id)));
    }

    @PutMapping("/api/boards/{id}")
    public ResponseEntity<Void> updateBoard(@PathVariable Long id, @RequestBody AddBoardRequest request) {
        boardService.updateBoard(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/boards/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok().build();
    }
}
