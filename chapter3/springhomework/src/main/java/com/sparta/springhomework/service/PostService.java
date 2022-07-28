package com.sparta.springhomework.service;

import com.sparta.springhomework.dto.PostRequestDto;
import com.sparta.springhomework.entity.Post;
import com.sparta.springhomework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional(rollbackFor = Exception.class)
    public Post update(Long postId, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        post.update(postRequestDto);
        return post;
    }

}
