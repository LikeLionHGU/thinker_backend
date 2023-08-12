package com.likelion.thinker.dto.response.comment;

import com.likelion.thinker.dto.CommentDto;
import com.likelion.thinker.dto.response.post.PostByCommentResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentByPostResponse {
    private Long commentId;

    private Integer commentLikeCount;

    private String content;

    public static CommentByPostResponse toCommentByPostResponse(CommentDto commentDto) {
        return CommentByPostResponse.builder()
                .commentId(commentDto.getCommentId())
                .commentLikeCount(commentDto.getCommentLikeDtoList().size())
                .content(commentDto.getContent())
                .build();
    }
}
