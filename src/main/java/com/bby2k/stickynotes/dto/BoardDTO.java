package com.bby2k.stickynotes.dto;


import java.util.List;
import java.util.UUID;

public record BoardDTO(
        UUID id,
        String title,
        List<UserDTO> users,
        List<NoteDTO> notes
    ){
}
