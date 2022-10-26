package com.bby2k.stickynotes.dto;

import com.bby2k.stickynotes.entity.Note;
import com.bby2k.stickynotes.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {
    private UUID id;
    @JsonRawValue
    private String title;
    @JsonIgnore
    private Map<String, String> users;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NoteDTO> notes;

    public BoardDTO(UUID id, String title) {
        users = new HashMap<>();
        notes = new ArrayList<>();
        this.id = id;
        this.title = title;
    }

    public void convertUsersData(Set<User> userEntities){
        for(User user: userEntities){
            users.put(user.getUsername(), "http://localhost:8080/user/"+user.getId());
        }
    }

    public void convertNotesData(Set<Note> noteEntities){
        for(Note note: noteEntities){
            NoteDTO noteDTO = new NoteDTO(note.getId(), note.getTitle(), note.getContent());
            notes.add(noteDTO);
        }
    }

}
