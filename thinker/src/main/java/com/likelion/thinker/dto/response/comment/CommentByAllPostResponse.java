package com.likelion.thinker.dto.response.comment;

import com.likelion.thinker.dto.CommentDto;
import com.likelion.thinker.dto.response.post.PostByCommentResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentByAllPostResponse {
    private Long commentId;
    private PostByCommentResponse post;
    private Integer commentLikeCount;
    private String content;

    public static CommentByAllPostResponse toCommentResponse(CommentDto commentDto) {
        return CommentByAllPostResponse.builder()
                .commentId(commentDto.getCommentId())
                .post(commentDto.getPostDto())
                .commentLikeCount(commentDto.getCommentLikeDtoList().size())
                .content(commentDto.getContent())
                .build();
    }
}
