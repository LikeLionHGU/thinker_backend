package com.likelion.thinker.controller;

import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.dto.request.PostRequest;
import com.likelion.thinker.dto.response.post.APostResponse;
import com.likelion.thinker.dto.response.post.AllPostResponse;
import com.likelion.thinker.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
@CrossOrigin(origins = "*")
public class PostController {
    private final PostService postService;


    @PostMapping("/{userId}")
    public ResponseEntity<Long> addOnePost(@PathVariable Long userId, @RequestBody PostRequest postRequest) {
        PostDto postDto = PostDto.toAdd(postRequest);
        Long postId = postService.addPost(userId, postDto);

        return ResponseEntity.ok(postId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<AllPostResponse>> getAllPost(@PathVariable Long userId) {
        List<PostDto> postDtoList = postService.getAllPost(userId);
        List<AllPostResponse> allPostResponseList = postDtoList.stream().map(AllPostResponse::toResponse).collect(Collectors.toList());

        return ResponseEntity.ok(allPostResponseList);
    }

    @GetMapping("/{postId}/{userId}")
    public ResponseEntity<APostResponse> getOnePost(@PathVariable Long postId, @PathVariable Long userId) {
        PostDto postDto = postService.getPost(postId, userId);
        APostResponse aPostResponse = APostResponse.toResponse(postDto);

        return ResponseEntity.ok(aPostResponse);
    }
}
