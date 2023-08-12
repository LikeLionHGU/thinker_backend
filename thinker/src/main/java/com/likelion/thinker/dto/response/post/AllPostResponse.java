package com.likelion.thinker.dto.response.post;

import com.likelion.thinker.dto.MemberDto;
import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.dto.response.member.MemberByPostResponse;
import com.likelion.thinker.dto.response.postLike.PostLikeDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AllPostResponse {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime date;

    private MemberByPostResponse member;

    private Integer postLikeCount;

    public static AllPostResponse toResponse(PostDto postDto) {
        return AllPostResponse.builder()
                .postId(postDto.getPostId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .date(postDto.getDate())
                .member(MemberByPostResponse.toMemberByPostResponse(postDto.getMemberDto()))
                .postLikeCount(postDto.getTotalPostLikeCount())
                .build();
    }
}
