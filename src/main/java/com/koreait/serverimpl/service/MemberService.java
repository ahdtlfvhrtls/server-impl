package com.koreait.serverimpl.service;

import com.koreait.serverimpl.dto.MemberDTO;

public interface MemberService {
    void insertMember(MemberDTO member);
    String login(String username, String password);
    MemberDTO getUserInfoFromToken(String token);
    void logout(String token);
    void update(String token, MemberDTO member);
}
