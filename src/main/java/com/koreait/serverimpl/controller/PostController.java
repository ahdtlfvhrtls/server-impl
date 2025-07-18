package com.koreait.serverimpl.controller;


import com.koreait.serverimpl.dto.PostDTO;
import com.koreait.serverimpl.jwt.JwtUtil;
import com.koreait.serverimpl.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final JwtUtil jwtUtil;

    @PostMapping("/write")
    public ResponseEntity<?> create(@RequestBody PostDTO post, HttpServletRequest request) {
        int writerId = jwtUtil.getUserIdFromRequest(request);
        post.setWriterId(writerId);
        postService.insertPost(post);
        return ResponseEntity.ok(post);

    }

    @GetMapping("/")
    public List<PostDTO> list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return postService.getPostList(page, size);
    }

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PutMapping("/write/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PostDTO post, HttpServletRequest request) {
        int writerId = jwtUtil.getUserIdFromRequest(request);
        post.setId(id);
        post.setWriterId(writerId);
        postService.updatePost(post);
        return ResponseEntity.ok("게시글이 수정되었습니다.");
    }

    @DeleteMapping("/write/{id}")
    public ResponseEntity<?> delete(@PathVariable int id, HttpServletRequest request) {
        int writerId = jwtUtil.getUserIdFromRequest(request);
        PostDTO post = new PostDTO();
        post.setId(id);
        post.setWriterId(writerId);
        postService.deletePost(post);
        return ResponseEntity.ok("게시글이 삭제되었습니다.");
    }
}
