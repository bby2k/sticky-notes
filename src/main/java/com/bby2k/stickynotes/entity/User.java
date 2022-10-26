package com.bby2k.stickynotes.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_details")
@Entity
public class User {
    @Id
    private UUID id = UUID.randomUUID();
    private String username;
    private String email;
    private String hashedPassword;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "joinedUsers")
    private Set<Board> usersBoardEntities = new HashSet<>();

    public User(String username, String email, String hashedPassword) {
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

}
