package com.likelion.thinker.dto;

import com.likelion.thinker.entity.CommentLike;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentLikeDto {
    private Long commentLikeId;

    public static CommentLikeDto toResponse(CommentLike commentLike) {
        return CommentLikeDto.builder()
                .commentLikeId(commentLike.getCommentLikeId())
                .build();
    }
}
