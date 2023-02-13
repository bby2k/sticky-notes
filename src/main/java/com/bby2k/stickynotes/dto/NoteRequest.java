package com.bby2k.stickynotes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteRequest {

    private UUID noteId;
    private UUID boardId;
    private UUID userId;
    private String title;
    private String content;

}
