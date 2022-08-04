package com.sparta.assignment041.controller;

import com.sparta.assignment041.dto.CommentRequestDto;
import com.sparta.assignment041.dto.PostRequestDto;
import com.sparta.assignment041.dto.ResponseDto;
import com.sparta.assignment041.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/auth/comment")
    public ResponseDto<?> createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    @GetMapping("/comment")
    public ResponseDto<?> getAllComments() {
        return commentService.getAllComments();
    }

    @PutMapping("/auth/comment/{id}")
    public ResponseDto<?> updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(id, requestDto);
    }

    @DeleteMapping("/auth/comment/{id}")
    public ResponseDto<?> deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }

}
