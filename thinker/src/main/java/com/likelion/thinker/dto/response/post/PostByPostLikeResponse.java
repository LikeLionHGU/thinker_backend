package com.likelion.thinker.dto.response.post;

import com.likelion.thinker.dto.PostDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostByPostLikeResponse {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime date;

    private String writer;

    public static PostByPostLikeResponse toPostByPostLikeResponse(PostDto postDto) {
        return PostByPostLikeResponse.builder()
                .postId(postDto.getPostId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .date(postDto.getDate())
                .writer(postDto.getMemberDto().getName())
                .build();
    }
}
