package com.koreait.serverimpl.service;

import com.koreait.serverimpl.dto.PostDTO;
import com.koreait.serverimpl.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;

    @Override
    public void insertPost(PostDTO postDTO) {
        postMapper.insertPost(postDTO);
    }

    @Override
    public void updatePost(PostDTO postDTO) {
        postMapper.updatePost(postDTO);
    }

    @Override
    public void deletePost(PostDTO postDTO) {
        postMapper.deletePost(postDTO);
    }

    @Override
    public List<PostDTO> getPostList(int page, int size) {
        int offset = (page - 1) * size;
        return postMapper.getPostList(offset, size);
    }

    @Override
    public PostDTO getPostById(int id) {
        return postMapper.getPostById(id);
    }
}
