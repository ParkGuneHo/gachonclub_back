package kr.ac.gachon.gc.gachonclub_back.Service;

import kr.ac.gachon.gc.gachonclub_back.Domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> findAll(String club);
    List<Board> findByClubAndCalendarContaining(String club, String calendar);
    Board findById(Long boardId);
    Board addBoard(Board board);
    Board editBoard(Board board);
    boolean deleteById(Long boardId);
}
