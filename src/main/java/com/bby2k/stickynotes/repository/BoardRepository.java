package com.bby2k.stickynotes.repository;

import com.bby2k.stickynotes.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<Board, UUID> {
    Board getBoardById(UUID id);
}
