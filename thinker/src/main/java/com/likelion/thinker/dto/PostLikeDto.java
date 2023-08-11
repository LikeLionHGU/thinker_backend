package com.likelion.thinker.dto;

import com.likelion.thinker.entity.PostLike;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostLikeDto {
    private Long postLikeId;

    public static PostLikeDto toResponse(PostLike postLike) {
        return PostLikeDto.builder()
                .postLikeId(postLike.getPostLikeId())
                .build();
    }
}
