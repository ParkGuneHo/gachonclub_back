package kr.ac.gachon.gc.gachonclub_back.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    // 동아리 분류
    @Column(nullable = false)
    private String club;

    // 게시판 제목
    @Column(nullable = false)
    private String title;

    // 게시판 내용
    @Column(nullable = false)
    @Type(type="text")
    private String content;

    // 게시판 글쓴이
    @Column(nullable = false)
    private String name;

    // 게시판 작성시간
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;

    // 캘린더 일정
    @Column(nullable = false)
    private String calendar;
}
