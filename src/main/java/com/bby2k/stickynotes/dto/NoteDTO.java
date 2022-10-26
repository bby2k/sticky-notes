package com.bby2k.stickynotes.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class NoteDTO {
    private UUID id;

    @JsonRawValue
    private String title;

    @JsonRawValue
    private String content;

    public NoteDTO(UUID id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
