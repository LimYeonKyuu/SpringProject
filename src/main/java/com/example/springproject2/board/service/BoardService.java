package com.example.springproject2.board.service;

import com.example.springproject2.board.controller.dto.BoardDto;
import com.example.springproject2.board.controller.request.AddBoardRequest;
import com.example.springproject2.board.entity.Board;
import com.example.springproject2.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void createBoard(AddBoardRequest request) {
        boardRepository.save(Board.from(request.getTitle(), request.getContent()));
    }

    public List<BoardDto> getBoards() {
        return boardRepository.findAll().stream()
                .map(BoardDto::from)
                .collect(Collectors.toList());
    }

    public BoardDto getBoard(Long id) {
        return BoardDto.from(boardRepository.findById(id).orElseThrow());
    }

    public void updateBoard(Long id, AddBoardRequest request) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.update(request.getTitle(), request.getContent());
        boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
