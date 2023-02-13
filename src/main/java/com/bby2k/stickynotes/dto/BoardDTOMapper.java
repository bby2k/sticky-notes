package com.bby2k.stickynotes.dto;

import com.bby2k.stickynotes.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardDTOMapper implements Function<Board, BoardDTO> {

    private final UserDTOMapper userDTOMapper;

    private final NoteDTOMapper noteDTOMapper;

    @Override
    public BoardDTO apply(Board board) {
        return new BoardDTO(
                board.getId(),
                board.getTitle(),
                board.getJoinedUsers().stream().map(userDTOMapper).collect(Collectors.toList()),
                board.getNotesInBoard().stream().map(noteDTOMapper).collect(Collectors.toList())
        );
    }
}
