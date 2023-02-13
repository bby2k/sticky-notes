package com.bby2k.stickynotes.repository;

import com.bby2k.stickynotes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
    Note save(Note note);
}
