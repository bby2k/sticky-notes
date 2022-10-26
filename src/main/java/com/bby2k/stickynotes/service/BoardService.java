package com.bby2k.stickynotes.service;

import com.bby2k.stickynotes.dto.BoardDTO;
import com.bby2k.stickynotes.entity.Board;
import com.bby2k.stickynotes.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    private BoardRepository repository;

    public Board getBoard(UUID id) {
        return repository.getBoardById(id);
    }
    public BoardDTO getBoardDTO(UUID id){
        Board board = repository.getBoardById(id);
        BoardDTO boardDTO = new BoardDTO(board.getId(), board.getTitle());
        boardDTO.convertUsersData(board.getJoinedUsers());
        boardDTO.convertNotesData(board.getNotesInBoard());
        return boardDTO;
//        return repository.getBoardById(id);
    }

    public void saveBoard(Board board) {
        repository.save(board);
    }

    public void deleteBoard(UUID id) {
        repository.deleteById(id);
    }

    public List<Board> getAllBoards() {
        return repository.findAll();
    }

    public List<BoardDTO> getAllBoardDTOs() {
        List<Board> boards = getAllBoards();
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for(Board board: boards){
            boardDTOS.add(new BoardDTO(board.getId(), board.getTitle()));
        }
        return boardDTOS;
    }

    public void updateBoard(UUID id, String newTitle) {
        Board board = getBoard(id);
        board.setTitle(newTitle);
        saveBoard(board);
    }
}
