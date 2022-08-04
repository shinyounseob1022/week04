package com.sparta.assignment041.service;

import com.sparta.assignment041.dto.CommentRequestDto;
import com.sparta.assignment041.dto.PostRequestDto;
import com.sparta.assignment041.dto.ResponseDto;
import com.sparta.assignment041.entity.Comment;
import com.sparta.assignment041.entity.Post;
import com.sparta.assignment041.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public ResponseDto<?> createComment(CommentRequestDto requestDto) {

        Comment comment = new Comment(requestDto);

        commentRepository.save(comment);

        return ResponseDto.success(comment);
    }

    @Transactional(readOnly = true)
    public ResponseDto<?> getAllComments() {
        return ResponseDto.success(commentRepository.findAllByOrderByModifiedAtDesc());
    }

    @Transactional
    public ResponseDto<Comment> updateComment(Long id, CommentRequestDto requestDto) {
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if (optionalComment.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exist");
        }

        Comment comment = optionalComment.get();
        comment.update(requestDto);

        return ResponseDto.success(comment);
    }

    @Transactional
    public ResponseDto<?> deleteComment(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if (optionalComment.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }

        Comment comment = optionalComment.get();

        commentRepository.delete(comment);

        return ResponseDto.success(true);
    }
}
