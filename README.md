# restAPI를 활용한 게시판 제작 프로젝트 

## 프로젝트 개요
- Spring Boot, MyBatis, JWT, BCrypt를 사용한 로그인/회원가입/게시판 구현 프로젝트
- MySQL 데이터베이스 연동
- REST API 방식으로 회원관리 및 게시판 기능 제공

## 주요 기능
- 회원가입, 로그인, 회원정보 조회 및 수정
- JWT를 활용한 인증/인가 처리
- 게시글 작성, 조회, 수정, 삭제 기능

## 개발 환경
- Java 17
- Spring Boot 3.5.3
- MyBatis 3.0.3
- MySQL 8.0.33
- Lombok
- jjwt 0.11.5

## 실행 방법
1. MySQL에 `server` 데이터베이스 생성 및 환경설정 (`src/main/resources/application.properties` 수정)
2. 프로젝트 빌드 및 실행
   ```bash
   ./gradlew bootRun
3. 브라우저에서 http://localhost:8080 접속 후 API 테스트

API 주요 경로
POST /member/register : 회원가입

POST /member/login : 로그인

GET /member/info : 내 회원정보 조회

POST /member/logout : 로그아웃

POST /member/update : 회원정보 수정

GET /posts/ : 게시글 리스트 조회

GET /posts/{id} : 특정 게시글 조회

POST /posts/write : 게시글 작성

PUT /posts/{id} : 게시글 수정

DELETE /posts/{id} : 게시글 삭제
