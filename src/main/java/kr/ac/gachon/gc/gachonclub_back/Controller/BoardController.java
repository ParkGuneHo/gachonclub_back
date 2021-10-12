package kr.ac.gachon.gc.gachonclub_back.Controller;

import kr.ac.gachon.gc.gachonclub_back.Domain.Board;
import kr.ac.gachon.gc.gachonclub_back.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/board/getAll/{club}")
    public List getAllBoard(@PathVariable String club){
        return this.boardService.findAll(club);
    }

    @GetMapping("/board/getAll/{club}/{calendar}")
    public List getAllBoard_calendar(@PathVariable String club, @PathVariable String calendar){
        return this.boardService.findByClubAndCalendarContaining(club, calendar);
    }

    @GetMapping("/board/get/{id}")
    public Board getBoard(@PathVariable Long id){
        return this.boardService.findById(id);
    }

    @PostMapping("/board/add")
    public Board addBoard(@RequestBody Board board){
        return this.boardService.addBoard(board);
    }

    @PutMapping("/board/edit")
    public Board modifyBoard(@RequestBody Board board){
        return this.boardService.editBoard(board);
    }

    @DeleteMapping("/board/delete/{id}")
    public boolean deleteBoard(@PathVariable Long id){
        return this.boardService.deleteById(id);
    }
}
