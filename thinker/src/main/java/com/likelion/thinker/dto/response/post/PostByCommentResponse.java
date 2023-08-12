package com.likelion.thinker.dto.response.post;

import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.entity.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostByCommentResponse {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime date;

    private String writer;

    public static PostByCommentResponse toPostByCommentResponse(Post post) {
        return PostByCommentResponse.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .date(post.getDate())
                .writer(post.getMember().getName())
                .build();
    }
}
