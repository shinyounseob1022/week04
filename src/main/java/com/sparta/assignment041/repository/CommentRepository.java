package com.sparta.assignment041.repository;

import com.sparta.assignment041.entity.Comment;
import com.sparta.assignment041.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByModifiedAtDesc();
    Optional<Comment> findById(Long id);
}
