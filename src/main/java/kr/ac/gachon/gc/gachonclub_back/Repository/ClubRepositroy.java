package kr.ac.gachon.gc.gachonclub_back.Repository;

import kr.ac.gachon.gc.gachonclub_back.Domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClubRepositroy extends JpaRepository<Club, Long> {
    List<Club> findByHead(String Head);
    Optional<Club> findByName(String name);
}
