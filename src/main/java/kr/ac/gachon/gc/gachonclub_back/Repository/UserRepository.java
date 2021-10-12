package kr.ac.gachon.gc.gachonclub_back.Repository;

import kr.ac.gachon.gc.gachonclub_back.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}
