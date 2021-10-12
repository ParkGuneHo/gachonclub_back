package kr.ac.gachon.gc.gachonclub_back.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    // 동아리 분류
    @Column(nullable = false)
    private String head;

    // 동아리 이름
    @Column(nullable = false)
    private String name;

    // 동아리 소개
    @Column(nullable = false)
    private String info;

    // 동아리 로고
    @Column(nullable = false)
    private String logo;

    // 동아리 내용
    @Column(nullable = false)
    @Type(type="text")
    private String data;
}
