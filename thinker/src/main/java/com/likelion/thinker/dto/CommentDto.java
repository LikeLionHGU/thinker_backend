package com.likelion.thinker.dto;

import com.likelion.thinker.dto.response.post.PostByCommentResponse;
import com.likelion.thinker.entity.Comment;
import com.likelion.thinker.dto.request.CommentRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CommentDto {
    private Long commentId;

    private MemberDto memberDto;

    private PostByCommentResponse postDto;

    private List<CommentLikeDto> commentLikeDtoList;

    private String content;

    private Boolean isLiked;

    public static CommentDto toResponse(Comment comment) {
        return CommentDto.builder()
                .content(comment.getContent())
                .commentId(comment.getCommentId())
                .memberDto(MemberDto.toPostResponse(comment.getMember()))
                .postDto(PostByCommentResponse.toPostByCommentResponse(comment.getPost()))
                .commentLikeDtoList(comment.getCommentLikeList().stream().map(CommentLikeDto::toResponse).collect(Collectors.toList()))
                .build();
    }


    public static CommentDto toMemberResponse(Comment comment) {
        return CommentDto.builder()
                .commentId(comment.getCommentId())
                .content(comment.getContent())
                .postDto(PostByCommentResponse.toPostByCommentResponse(comment.getPost()))
                .commentLikeDtoList(comment.getCommentLikeList().stream().map(CommentLikeDto::toResponse).collect(Collectors.toList()))
                .build();
    }

    public static CommentDto toAdd(CommentRequest commentRequest) {
        return CommentDto.builder()
                .content(commentRequest.getContent())
                .build();
    }
}
