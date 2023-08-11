package com.likelion.thinker.dto;

import com.likelion.thinker.entity.Member;
import com.likelion.thinker.entity.Post;
import com.likelion.thinker.entity.PostLike;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostLikeDto {
    private Long postLikeId;

    private PostDto postDto;

    private MemberDto memberDto;

    public static PostLikeDto toResponse(PostLike postLike) {
        return PostLikeDto.builder()
                .postLikeId(postLike.getPostLikeId())
                .build();
    }

    public static PostLikeDto toMemberResponse(PostLike postLike) {
        return PostLikeDto.builder()
                .postLikeId(postLike.getPostLikeId())
                .postDto(PostDto.toMemberResponse(postLike.getPost()))
                .build();
    }
}
