package com.koreait.serverimpl.controller;



import com.koreait.serverimpl.dto.MemberDTO;
import com.koreait.serverimpl.jwt.JwtUtil;
import com.koreait.serverimpl.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MemberDTO member) {
        service.insertMember(member);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDTO member) {
        String token = service.login(member.getUsername(), member.getPassword());
        if (token != null) {
            return ResponseEntity.ok().body(token);
        }else{
            return ResponseEntity.status(401).body("로그인 실패");
        }
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String token) {
        MemberDTO member = service.getUserInfoFromToken(token);
        if (member != null) {
            return ResponseEntity.ok(member);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        service.logout(token);
        return ResponseEntity.ok("로그아웃 성공");
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestHeader("Authorization") String token, @RequestBody MemberDTO member) {
        service.update(token, member);
        return ResponseEntity.ok("회원정보 수정 성공");
    }


}
