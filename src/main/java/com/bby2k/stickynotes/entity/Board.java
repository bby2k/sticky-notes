package com.bby2k.stickynotes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id = UUID.randomUUID();
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "joined_users",
            joinColumns = @JoinColumn(name = "board_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "user_entity_id")

    )
    @JsonIgnore
    private Set<User> joinedUsers = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "board")
//    @JoinTable(
//            name = "notes_in_board",
//            joinColumns = @JoinColumn(name = "board_entity_id"),
//            inverseJoinColumns = @JoinColumn(name = "note_id")
//    )
    private Set<Note> notesInBoard = new HashSet<>();

    public Board(String title) {
        this.title = title;
    }

    public void joinTable(User user){
        joinedUsers.add(user);
    }

    public void leaveTable(User user){
        joinedUsers.remove(user);
    }
    public void addNote(Note note){
        notesInBoard.add(note);
    }
    public void removeNote(Note note){
        notesInBoard.remove(note);
    }
}
