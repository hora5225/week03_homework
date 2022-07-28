package com.sparta.springhomework.repository;

import com.sparta.springhomework.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
