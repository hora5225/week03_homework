package com.sparta.springhomework.entity;

import com.sparta.springhomework.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Post extends Timestamped {

    @Id //primary key 로 쓰겠다
    @GeneratedValue(strategy = GenerationType.AUTO) //자동 증가 명령
    private Long postId;
    @Column
    private String userName;
    @Column
    private String postName;
    @Column
    private String postContent;
    @Column
    private String password;

    //생성자
    public Post(String userName, String postName, String postContent, String password) {
        this.userName = userName;
        this.postName = postName;
        this.postContent = postContent;
        this.password = password;
    }

    public Post(PostRequestDto postRequestDto){
        this.userName = postRequestDto.getUserName();
        this.postName = postRequestDto.getPostName();
        this.postContent = postRequestDto.getPostContent();
        this.password = postRequestDto.getPassword();
    }

    public void update (PostRequestDto postRequestDto) {
        this.userName = postRequestDto.getUserName();
        this.postName = postRequestDto.getPostName();
        this.postContent = postRequestDto.getPostContent();
        this.password = postRequestDto.getPassword();
    }

}
