package kr.ac.gachon.gc.gachonclub_back.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    // 유저 아이디
    @Column(nullable = false)
    private String userId;

    // 유저 비밀번호
    @Column(nullable = false)
    private String userPw;

    // 유저 이름
    @Column(nullable = false)
    private String name;

    // 유저 학과
    @Column(nullable = false)
    private String major;

    // 유저 동아리
    @Column(nullable = false)
    private String club;

    // 유저 직책
    @Column(nullable = false)
    private String position;
}
