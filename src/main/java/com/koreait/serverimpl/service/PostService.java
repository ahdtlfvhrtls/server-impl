package com.koreait.serverimpl.service;

import com.koreait.serverimpl.dto.PostDTO;

import java.util.List;

public interface PostService {
    void insertPost(PostDTO postDTO);
    void updatePost(PostDTO postDTO);
    void deletePost(PostDTO postDTO);
    List<PostDTO> getPostList(int page, int size);
    PostDTO getPostById(int id);
}
