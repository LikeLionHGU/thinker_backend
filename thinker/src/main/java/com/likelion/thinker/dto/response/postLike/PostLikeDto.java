package com.likelion.thinker.dto.response.postLike;

import com.likelion.thinker.dto.MemberDto;
import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.entity.PostLike;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostLikeDto {
    private Long postLikeId;

    private PostDto post;

    private MemberDto memberDto;

    public static PostLikeDto toResponse(PostLike postLike) {
        return PostLikeDto.builder()
                .postLikeId(postLike.getPostLikeId())
                .build();
    }

    public static PostLikeDto toMemberResponse(PostLike postLike) {
        return PostLikeDto.builder()
                .postLikeId(postLike.getPostLikeId())
                .post(PostDto.toResponse(postLike.getPost()))
                .build();
    }
}
