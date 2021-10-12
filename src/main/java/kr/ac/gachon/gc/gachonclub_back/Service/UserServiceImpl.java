package kr.ac.gachon.gc.gachonclub_back.Service;

import kr.ac.gachon.gc.gachonclub_back.Domain.User;
import kr.ac.gachon.gc.gachonclub_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() { return this.userRepository.findAll(); }

    @Override
    public User findById(String userId) { return this.userRepository.findByUserId(userId).orElse(null); }

    @Override
    public User addUser(User user) {
        Optional<User> found = this.userRepository.findByUserId(user.getUserId());
        if(found.isPresent()){
            return null;
        }
        return this.userRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return this.userRepository.findByUserId(user.getUserId())
                .map(p -> {
                    p.setName(Optional.ofNullable(user.getName()).orElse(p.getName()));
                    p.setMajor(Optional.ofNullable(user.getMajor()).orElse(p.getMajor()));
                    p.setClub(Optional.ofNullable(user.getClub()).orElse(p.getClub()));
                    p.setPosition(Optional.ofNullable(user.getPosition()).orElse(p.getPosition()));

                    return this.userRepository.save(p);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteById(String userId) {
        User found = this.userRepository.findByUserId(userId).orElse(null);
        if(found != null){
            userRepository.deleteById(found.get_id());
            return true;
        }
        return false;
    }
}
