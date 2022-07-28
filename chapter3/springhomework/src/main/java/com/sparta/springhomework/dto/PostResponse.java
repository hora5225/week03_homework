package com.sparta.springhomework.dto;

import com.sparta.springhomework.entity.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostResponse {
    private final String userName;
    private final String postName;
    private final String postContent;
}
