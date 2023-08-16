package com.likelion.thinker.controller;

import com.likelion.thinker.service.CommentLikeService;
import com.likelion.thinker.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/like")
@CrossOrigin(origins = "*")
public class LikeController {
    private final CommentLikeService commentLikeService;
    private final PostLikeService postLikeService;

    @PostMapping("/comment/{commentId}/{userId}")
    public ResponseEntity<Long> addCommentLike(@PathVariable Long commentId, @PathVariable Long userId) {
        Long responseId = commentLikeService.addCommentLike(userId, commentId);

        return ResponseEntity.ok(responseId);
    }

    @DeleteMapping("/comment/{commentId}/{userId}")
    public ResponseEntity<Long> deleteCommentLike(@PathVariable Long commentId, @PathVariable Long userId) {
        Long responseId = commentLikeService.deleteCommentLike(userId, commentId);

        return ResponseEntity.ok(responseId);
    }

    @PostMapping("/post/{postId}/{userId}")
    public ResponseEntity<Long> addPostLike(@PathVariable Long postId, @PathVariable Long userId) {
        Long responseId = postLikeService.addPostLike(userId, postId);

        return ResponseEntity.ok(responseId);
    }

    @DeleteMapping("post/{postId}/{userId}")
    public ResponseEntity<Long> deletePostLike(@PathVariable Long postId, @PathVariable Long userId) {
        Long responseId = postLikeService.deletePostLike(userId, postId);

        return ResponseEntity.ok(responseId);
    }
}
