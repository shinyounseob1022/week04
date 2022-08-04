package com.sparta.assignment041.controller;

import com.sparta.assignment041.dto.PostRequestDto;
import com.sparta.assignment041.dto.ResponseDto;
import com.sparta.assignment041.jwt.JwtFilter;
import com.sparta.assignment041.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {
  private final PostService postService;

  @PostMapping("/auth/post")
  public ResponseDto<?> createPost(@RequestBody PostRequestDto postRequestDto) {
    return postService.createPost(postRequestDto);
  }

  @GetMapping("/post/{id}")
  public ResponseDto<?> getPost(@PathVariable Long id) {
    return postService.getPost(id);
  }

  @GetMapping("/post")
  public ResponseDto<?> getAllPosts() {
    return postService.getAllPost();
  }

  @PutMapping("/auth/post/{id}")
  public ResponseDto<?> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
    return postService.updatePost(id, postRequestDto);
  }

  @DeleteMapping("/auth/post/{id}")
  public ResponseDto<?> deletePost(@PathVariable Long id) {
    return postService.deletePost(id);
  }



}
