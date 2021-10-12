package kr.ac.gachon.gc.gachonclub_back.Service;

import kr.ac.gachon.gc.gachonclub_back.Domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String userId);
    User addUser(User user);
    User editUser(User user);
    boolean deleteById(String userId);
}
