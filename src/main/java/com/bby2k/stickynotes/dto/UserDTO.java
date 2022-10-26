package com.bby2k.stickynotes.dto;

import com.bby2k.stickynotes.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String username;
    private String email;
    private List<BoardDTO> boards;

    public UserDTO(UUID id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        boards = new ArrayList<>();
    }

    public void convertBoards(Set<Board> boardSet){
        for(Board board : boardSet){
            boards.add(new BoardDTO(board.getId(), board.getTitle()));
        }
    }
}
