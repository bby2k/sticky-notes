package com.bby2k.stickynotes.dto;

import com.bby2k.stickynotes.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequest {

    private UUID userId;
    private String boardTitle;

}
