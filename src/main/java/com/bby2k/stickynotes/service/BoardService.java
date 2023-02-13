package com.bby2k.stickynotes.service;

import com.bby2k.stickynotes.dto.BoardDTO;
import com.bby2k.stickynotes.dto.BoardDTOMapper;
import com.bby2k.stickynotes.dto.BoardRequest;
import com.bby2k.stickynotes.dto.NoteRequest;
import com.bby2k.stickynotes.entity.Board;
import com.bby2k.stickynotes.entity.Note;
import com.bby2k.stickynotes.entity.User;
import com.bby2k.stickynotes.repository.BoardRepository;
import com.bby2k.stickynotes.repository.NoteRepository;
import com.bby2k.stickynotes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final BoardDTOMapper boardDTOMapper;

    private final NoteRepository noteRepository;

    public List<BoardDTO> getAllBoards() {
        return boardRepository.findAll()
                .stream()
                .map(boardDTOMapper)
                .collect(Collectors.toList());
    }

    public void addBoard(BoardRequest boardRequest){
        Board board = new Board(boardRequest.getBoardTitle());
        Optional<User> creator = userRepository.getUserById(boardRequest.getUserId());
        creator.ifPresent(board::joinTable);
        boardRepository.save(board);
    }

    public BoardDTO getBoardById(UUID id) {
        return boardRepository.getBoardById(id)
                .map(boardDTOMapper)
                .orElseThrow(() -> new RuntimeException(
                        "board with id [$s] was not found".formatted(id)
                ));
    }

    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    public void deleteBoard(UUID id) {
        boardRepository.deleteById(id);
    }

    public void addNoteToBoard(NoteRequest noteRequest){
        Optional<Board> board = boardRepository.getBoardById(noteRequest.getBoardId());
        Optional<User> user = userRepository.getUserById(noteRequest.getUserId());

        Note note = new Note(
                noteRequest.getTitle(),
                noteRequest.getContent(),
                user.get(),
                board.get()
        );

        board.ifPresent(targetBoard -> targetBoard.addNote(note));

        noteRepository.save(note);

        board.ifPresent(value -> value.getNotesInBoard().forEach(targetNote -> System.out.println(targetNote.getTitle())));
//        board.ifPresent(boardRepository::save);
    }

}
