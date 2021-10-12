package kr.ac.gachon.gc.gachonclub_back.Service;

import kr.ac.gachon.gc.gachonclub_back.Domain.Board;
import kr.ac.gachon.gc.gachonclub_back.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Board> findAll(String club) {
        return this.boardRepository.findByClub(club);
    }

    @Override
    public List<Board> findByClubAndCalendarContaining(String club, String calendar) {
        return this.boardRepository.findByClubAndCalendarContaining(club, calendar);
    }

    @Override
    public Board findById(Long boardId) { return this.boardRepository.findById(boardId).orElse(null); }

    @Override
    public Board addBoard(Board board) {
        board.setDate(LocalDateTime.now());
        return this.boardRepository.save(board);
    }

    @Override
    public Board editBoard(Board board) {
        return this.boardRepository.findById(board.get_id())
                .map(p -> {
                    p.setTitle(Optional.ofNullable(board.getTitle()).orElse(p.getTitle()));
                    p.setContent(Optional.ofNullable(board.getContent()).orElse(p.getContent()));
                    p.setDate(LocalDateTime.now());
                    p.setCalendar(Optional.ofNullable(board.getCalendar()).orElse(p.getCalendar()));
                    return this.boardRepository.save(p);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteById(Long boardId) {
        Board found = this.boardRepository.findById(boardId).orElse(null);
        if(found != null){
            boardRepository.deleteById(found.get_id());
            return true;
        }
        return false;
    }
}