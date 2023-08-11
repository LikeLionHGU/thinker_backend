package com.likelion.thinker.controller;

import com.likelion.thinker.request.PostRequest;
import com.likelion.thinker.response.PostResponse;
import com.likelion.thinker.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;


    @PostMapping("/{userId}")
    public ResponseEntity<Long> addOnePost(@PathVariable Long userId, @RequestBody PostRequest postRequest) {
        Long postId = postService.addPost(userId, postRequest);

        return ResponseEntity.ok(postId);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPost() {
        List<PostResponse> postResponseList = postService.getAllPost();

        return ResponseEntity.ok(postResponseList);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getOnePost(@PathVariable Long postId) {
        PostResponse postResponse = postService.getPost();

        return ResponseEntity.ok(postResponse);
    }
}
