가천대학교 - 모바일 프로그래밍(수업 프로젝트)
===============================
모바일 웹서버 구현

개발환경
-------------
 SpringBoot, MySql, JPA
 
사용 라이브러리
-------------
 lombok

Service
-------------
 각 모델의 CRUD 기능 구현

Repository
-------------
 JPA를 통한 MySql 연동
 
디자인패턴 - MVC 패턴
-------------
 모델 - Domain
  1. 게시판(Board)
     각 동아리의 공지사항 정보
  2. 사용자(User)
     회원 정보
  3. 동아리(Club)
     각 동아리 세부 정보
     
 컨트롤러 - Controller
  1. BoardController
  2. UserController
  3. ClubController 
