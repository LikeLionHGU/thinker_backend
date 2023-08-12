package com.likelion.thinker.dto.response.post;

import com.likelion.thinker.dto.MemberDto;
import com.likelion.thinker.dto.PostDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostByMemberResponse {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime date;

    private String writer;

    private Integer totalPostLikeCount;

    public static PostByMemberResponse toPostByMemberResponse(PostDto postDto) {
        return PostByMemberResponse.builder()
                .postId(postDto.getPostId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .date(postDto.getDate())
                .writer(postDto.getWriter())
                .totalPostLikeCount(postDto.getTotalPostLikeCount())
                .build();

    }
}
