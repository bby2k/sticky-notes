package com.bby2k.stickynotes.service;

import com.bby2k.stickynotes.entity.Note;
import com.bby2k.stickynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public void addNote(Note note, UUID boardId){
        noteRepository.save(note);
    }

    public void saveNote(Note note) {
        noteRepository.save(note);
    }
}
