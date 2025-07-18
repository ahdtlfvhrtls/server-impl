package com.koreait.serverimpl.mapper;

import com.koreait.serverimpl.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(PostDTO post);
    void updatePost(PostDTO post);
    void deletePost(PostDTO post);
    List<PostDTO> getPostList(@Param("offset") int offset, @Param("limit") int limit);
    PostDTO getPostById(@Param("id") int id);
}
