package com.koreait.serverimpl.mapper;

import com.koreait.serverimpl.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    void insertMember(MemberDTO member);
    void updateMember(MemberDTO member);
    MemberDTO findMember(@Param("username") String username);
}
