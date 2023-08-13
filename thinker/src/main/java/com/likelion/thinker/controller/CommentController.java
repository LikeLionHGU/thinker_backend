package com.likelion.thinker.controller;

import com.likelion.thinker.dto.CommentDto;
import com.likelion.thinker.dto.request.CommentRequest;
import com.likelion.thinker.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/add/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{userId}/{postId}")
    public ResponseEntity<Long> addComment(@PathVariable String userId, @PathVariable Long postId, @RequestBody CommentRequest commentRequest) {
        Long responseId = commentService.addComment(userId, postId, CommentDto.toAdd(commentRequest));

        return ResponseEntity.ok(responseId);
    }
}
