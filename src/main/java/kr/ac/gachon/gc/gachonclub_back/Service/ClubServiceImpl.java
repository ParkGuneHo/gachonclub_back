package kr.ac.gachon.gc.gachonclub_back.Service;

import kr.ac.gachon.gc.gachonclub_back.Domain.Club;
import kr.ac.gachon.gc.gachonclub_back.Repository.ClubRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService{

    @Autowired
    private ClubRepositroy clubRepositroy;

    @Override
    public List<Club> findAll(String head) {
        return this.clubRepositroy.findByHead(head);
    }

    @Override
    public Club findById(Long clubId) {
        return this.clubRepositroy.findById(clubId).orElse(null);
    }

    @Override
    public Club addClub(Club club) {
        Optional<Club> found = this.clubRepositroy.findByName(club.getName());
        if(found.isPresent()){
            return null;
        }
        return this.clubRepositroy.save(club);
    }

    @Override
    public Club editClub(Club club) {
        return this.clubRepositroy.findById(club.get_id())
                .map(p -> {
                    p.setName(Optional.ofNullable(club.getName()).orElse(p.getName()));
                    p.setInfo(Optional.ofNullable(club.getInfo()).orElse(p.getInfo()));
                    p.setData(Optional.ofNullable(club.getData()).orElse(p.getData()));

                    return this.clubRepositroy.save(p);
                })
                .orElse(null);
    }

    @Override
    public boolean deleteById(Long clubId) {
        Club found = this.findById(clubId);
        if(found != null){
            clubRepositroy.deleteById(clubId);
            return true;
        }
        return false;
    }
}
