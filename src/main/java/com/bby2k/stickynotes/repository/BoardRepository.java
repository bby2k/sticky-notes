package com.bby2k.stickynotes.repository;

import com.bby2k.stickynotes.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<Board, UUID> {
    Optional<Board> getBoardById(UUID id);
    Board save(Board board);
    void deleteById(UUID id);
}
