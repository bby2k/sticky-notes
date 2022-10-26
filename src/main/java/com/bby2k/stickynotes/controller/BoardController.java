package com.bby2k.stickynotes.controller;

import com.bby2k.stickynotes.dto.BoardDTO;
import com.bby2k.stickynotes.entity.Board;
import com.bby2k.stickynotes.entity.Note;
import com.bby2k.stickynotes.entity.User;
import com.bby2k.stickynotes.service.BoardService;
import com.bby2k.stickynotes.service.NoteService;
import com.bby2k.stickynotes.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    //WebSocket Message Mapping
//    @MessageMapping("message")
//    @SendTo("/board")

    //CRUD operations
    @GetMapping(value = "/board/{id}")
    @ResponseBody
    public BoardDTO getBoard(@PathVariable("id") UUID id){
        return boardService.getBoardDTO(id);
    }

    @GetMapping(value = "/board")
    @ResponseBody
    public List<BoardDTO> getAllBoards(){
        return boardService.getAllBoardDTOs();
    }

    @PostMapping(value = "/board/user/{user_id}")
    @ResponseBody
    public void addBoard(@RequestBody ObjectNode json, @PathVariable("user_id") UUID id){
        User user = userService.getUserById(id);
        String title = String.valueOf(json.get("title"));
        Board board = new Board(title);
        board.joinTable(user);
        boardService.saveBoard(board);
    }

    @PutMapping(value = "/board/update/{id}")
    @ResponseBody
    public void updateBoard(@RequestBody ObjectNode json,@PathVariable("id") UUID id){
        String newTitle = String.valueOf(json.get("title"));
        boardService.updateBoard(id, newTitle);
    }
    @PutMapping(value = "/board/add-note")
    @ResponseBody
    public void addNoteToBoard(@RequestBody ObjectNode json, @RequestParam(required = false)Map<String, String> allParams){
        UUID boardId = UUID.fromString(allParams.get("board_id"));
        UUID userId = UUID.fromString(allParams.get("user_id"));

        Board board = boardService.getBoard(boardId);
        User user = userService.getUserById(userId);

        String title = String.valueOf(json.get("title"));
        String content = String.valueOf(json.get("content"));

        Note note = new Note(title, content, user);
        board.addNote(note);

        noteService.saveNote(note);
        boardService.saveBoard(board);
    }

    @DeleteMapping(value = "/board/{id}")
    @ResponseBody
    public void deleteBoard(@PathVariable("id") UUID id){
        boardService.deleteBoard(id);
    }

}
