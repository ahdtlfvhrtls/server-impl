package com.koreait.serverimpl.service;

import com.koreait.serverimpl.dto.MemberDTO;
import com.koreait.serverimpl.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import com.koreait.serverimpl.mapper.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper mapper;
    private final JwtUtil jwtUtil;

    @Override
    public void insertMember(MemberDTO member) {
        String hashed = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt());
        member.setPassword(hashed);
        mapper.insertMember(member);

    }

    @Override
    public String login(String username, String password) {
        MemberDTO member = mapper.findMember(username);
        if (member != null && BCrypt.checkpw(password, member.getPassword())) {
            return jwtUtil.createToken(member.getUsername(), member.getId());
        }
        return null;
    }

    @Override
    public MemberDTO getUserInfoFromToken(String token) {
        String jwt = token.replace("Bearer ", "");
        String username = jwtUtil.getUsernameFromToken(jwt);
        MemberDTO member = mapper.findMember(username);
        if (member != null) {
            member.setPassword(null);
        }
        return member;
    }

    @Override
    public void logout(String token) {

    }

    @Override
    public void update(String token, MemberDTO member) {
        String jwt = token.replace("Bearer ", "");
        String username = jwtUtil.getUsernameFromToken(jwt);
        MemberDTO existing = mapper.findMember(username);
        if (existing != null) {
            if (StringUtils.hasText(member.getPassword())) {
                String hashed = BCrypt.hashpw(member.getPassword(), BCrypt.gensalt());
                existing.setPassword(hashed);
            }
            if(StringUtils.hasText(member.getName())){
                existing.setName(member.getName());
            }
            mapper.updateMember(existing);
        }

    }
}
