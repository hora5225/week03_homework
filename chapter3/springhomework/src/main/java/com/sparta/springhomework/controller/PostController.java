package com.sparta.springhomework.controller;

import com.sparta.springhomework.dto.PostRequestDto;
import com.sparta.springhomework.dto.PostResponse;
import com.sparta.springhomework.entity.Post;
import com.sparta.springhomework.repository.PostRepository;
import com.sparta.springhomework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor    //멤버로 선언된거중에 final 있으면 니가 알아서 생성해서 써라. 일일히 생성안해줘도댐
@RestController
public class PostController {

    public final PostRepository postRepository;
    public final PostService postService;

    //게시글 작성
    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto postRequestDto) {
        //create 할려면 데이터를 물고오는 소재가 필요하다
        Post post = new Post(postRequestDto);
        return postRepository.save(post);
    }

    //전체 게시글 조회
    @GetMapping("/api/posts")
    public List<PostResponse> lookupPostList() {    //리포지토리를 통해 findAll 한 다음 리턴
        //비밀번호 조회 안되게
        //작성 날짜 기준 내림차순
        //return postRepository.findAll();
        //이렇게 하면 안되고 dto 써야함
    }

    //단일 게시글 조회
    @GetMapping("/api/posts/{postId}")
    public Post lookupPost(@PathVariable Long postId) {
        return postRepository.findById(postId).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        //이렇게 하면 안되고 서비스쪽으로 돌려야함
    }

    //게시글 수정
   @PutMapping("/api/posts/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody PostRequestDto postRequestDto) {
       return postService.update(postId, postRequestDto);
    }

    @DeleteMapping("/api/posts/{postId}")
    public Long deletePost(@PathVariable Long postId) {
        postRepository.deleteById(postId);
        return postId;
    }
}
