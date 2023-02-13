package com.bby2k.stickynotes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id = UUID.randomUUID();
    private String title;
    private String content;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Board board;
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public Note(String title, String content, User user, Board board) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.board = board;
    }
}
