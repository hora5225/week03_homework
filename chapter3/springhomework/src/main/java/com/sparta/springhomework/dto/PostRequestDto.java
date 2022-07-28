package com.sparta.springhomework.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PostRequestDto {

    private final String userName;
    private final String postName;
    private final String postContent;
    private final String password;




//    //PostController 에서 사용함
//    public PostRequestDto(Long postId, String userName, String postName, String postContent, String password) {
//        this.userName = userName;
//        this.postName = postName;
//        this.postContent = postContent;
//        this.password = password;
//    }
}
