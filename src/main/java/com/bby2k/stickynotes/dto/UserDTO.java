package com.bby2k.stickynotes.dto;

import java.util.List;
import java.util.UUID;

public record UserDTO(
    UUID id,
    String username,
    String email,
    List<String> roles
    ){
}
