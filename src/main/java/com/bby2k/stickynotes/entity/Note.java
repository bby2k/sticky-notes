package com.bby2k.stickynotes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Note {
    @Id
    private final UUID id = UUID.randomUUID();
    private String title;
    private String content;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    private User user;



    public Note(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}
