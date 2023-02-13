package com.bby2k.stickynotes.dto;

import java.util.UUID;

public record NoteDTO(
        UUID id,
        String title,
        String content
) {
}
