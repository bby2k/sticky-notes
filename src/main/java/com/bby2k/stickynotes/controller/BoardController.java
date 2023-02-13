package com.bby2k.stickynotes.controller;

import com.bby2k.stickynotes.dto.BoardDTO;
import com.bby2k.stickynotes.dto.BoardRequest;
import com.bby2k.stickynotes.dto.NoteRequest;
import com.bby2k.stickynotes.entity.Board;
import com.bby2k.stickynotes.entity.Note;
import com.bby2k.stickynotes.entity.User;
import com.bby2k.stickynotes.service.BoardService;
import com.bby2k.stickynotes.service.NoteService;
import com.bby2k.stickynotes.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final UserService userService;

    private final NoteService noteService;


    // The board controller should be used for every board related requests.
    // -The board should contain the users who have access to the board.
    // -The board should contain all the notes that is assigned to it.

//[GET REQUESTS]########################################################################################
    // - GET all boards <ADMIN, SUPER_ADMIN>
    @GetMapping("/all")
    public ResponseEntity<Object> getAllBoards(){
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    // - GET board by id <IF VISITOR, USER IN GIVEN BOARD> <ADMIN, SUPER_ADMIN>
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBoardById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(boardService.getBoardById(id));
    }

    // - GET board users <IF VISITOR, USER IN GIVEN BOARD> <ADMIN, SUPER_ADMIN>
    @GetMapping("/{id}/users")
    public ResponseEntity<Object> getBoardUsersByBoardId(@PathVariable("id") UUID id){
        return null;
    }

    // - GET board notes <IF VISITOR, USER IN GIVEN BOARD> <ADMIN, SUPER_ADMIN>
    @GetMapping("/notes")
    public ResponseEntity<Object> getBoardNotesByBoardId(){
        return null;
    }

//[POST REQUESTS]#########################################################################################
    // - POST new board <ANY>
    @PostMapping()
    public ResponseEntity<Object> createBoard(@RequestBody BoardRequest boardRequest){
        boardService.addBoard(boardRequest);
        return ResponseEntity.ok("Board added.");
    }

    // - POST assign new user to the board (JOIN BOARD) <IF VISITOR, USER IN GIVEN BOARD>
    @PostMapping("/user")
    public ResponseEntity<Object> addUserToBoard(){
        return null;
    }

    // - POST new note to board <IF VISITOR, USER IN GIVEN BOARD>
    @PostMapping("/note")
    public ResponseEntity<Object> addNoteToBoard(@RequestBody NoteRequest noteRequest){
        boardService.addNoteToBoard(noteRequest);
        return ResponseEntity.ok("New Note added to [$s] board".formatted(noteRequest.getBoardId()));
    }


//[PUT REQUESTS]#########################################################################################
    // - PUT update board name <IF VISITOR, USER IN GIVEN BOARD>
    @PutMapping("/name")
    public ResponseEntity<Object> updateBoardName(){
        return null;
    }

    // - PUT update note <IF VISITOR, USER IN GIVEN BOARD>
    @PutMapping("/note")
    public ResponseEntity<Object> updateNoteById(){
        return null;
    }

//[DELETE REQUESTS]#########################################################################################
    // - DELETE board by id <BOARD OWNER> <ADMIN, SUPER_ADMIN>
    @DeleteMapping("/id")
    public ResponseEntity<Object> deleteBoardById(){
        return null;
    }

    // - DELETE note by id <IF VISITOR, USER IN GIVEN BOARD> <ADMIN,
    @DeleteMapping("/note")
    public ResponseEntity<Object> deleteNoteById(){
        return null;
    }

    // - DELETE (remove) user from board <BOARD OWNER>
    @DeleteMapping("/user")
    public ResponseEntity<Object> removeUserFromBoard(){
        return null;
    }


    //WebSocket Message Mapping
//    @MessageMapping("message")
//    @SendTo("/board")

    //CRUD operations
//    @GetMapping(value = "/board/{id}")
//    @ResponseBody
//    public BoardDTO getBoard(@PathVariable("id") UUID id){
//        return boardService.getBoardDTO(id);
//    }
//
//    @GetMapping(value = "/board")
//    @ResponseBody
//    public List<BoardDTO> getAllBoards(){
//        return boardService.getAllBoardDTOs();
//    }
//
//    @PostMapping(value = "/board/user/{user_id}")
//    @ResponseBody
//    public void addBoard(@RequestBody ObjectNode json, @PathVariable("user_id") UUID id){
//        User user = userService.getUserById(id);
//        String title = String.valueOf(json.get("title"));
//        Board board = new Board(title);
//        board.joinTable(user);
//        boardService.saveBoard(board);
//    }
//
//    @PutMapping(value = "/board/update/{id}")
//    @ResponseBody
//    public void updateBoard(@RequestBody ObjectNode json,@PathVariable("id") UUID id){
//        String newTitle = String.valueOf(json.get("title"));
//        boardService.updateBoard(id, newTitle);
//    }
//    @PutMapping(value = "/board/add-note")
//    @ResponseBody
//    public void addNoteToBoard(@RequestBody ObjectNode json, @RequestParam(required = false)Map<String, String> allParams){
//        UUID boardId = UUID.fromString(allParams.get("board_id"));
//        UUID userId = UUID.fromString(allParams.get("user_id"));
//
//        Board board = boardService.getBoard(boardId);
//        User user = userService.getUserById(userId);
//
//        String title = String.valueOf(json.get("title"));
//        String content = String.valueOf(json.get("content"));
//
//        Note note = new Note(title, content, user);
//        board.addNote(note);
//
//        noteService.saveNote(note);
//        boardService.saveBoard(board);
//    }
//
//    @DeleteMapping(value = "/board/{id}")
//    @ResponseBody
//    public void deleteBoard(@PathVariable("id") UUID id){
//        boardService.deleteBoard(id);
//    }

}
