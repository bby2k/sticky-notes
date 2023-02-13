package com.bby2k.stickynotes.dto;

import com.bby2k.stickynotes.entity.Note;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class NoteDTOMapper implements Function<Note, NoteDTO> {
    @Override
    public NoteDTO apply(Note note) {
        return new NoteDTO(
                note.getId(),
                note.getTitle(),
                note.getContent()
        );
    }
}
