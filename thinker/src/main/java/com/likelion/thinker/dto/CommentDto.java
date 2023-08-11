package com.likelion.thinker.dto;

import com.likelion.thinker.entity.Comment;
import com.likelion.thinker.request.CommentRequest;
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

    private PostDto postDto;

    private List<CommentLikeDto> commentLikeDtoList;

    private String content;

    public static CommentDto toResponse(Comment comment) {
        return CommentDto.builder()
                .commentId(comment.getCommentId())
                .memberDto(MemberDto.toPostResponse(comment.getMember()))
                .postDto(PostDto.toResponse(comment.getPost()))
                .commentLikeDtoList(comment.getCommentLikeList().stream().map(CommentLikeDto::toResponse).collect(Collectors.toList()))
                .build();
    }

    public static CommentDto toMemberResponse(Comment comment) {
        return CommentDto.builder()
                .commentId(comment.getCommentId())
                .postDto(PostDto.toMemberResponse(comment.getPost()))
                .commentLikeDtoList(comment.getCommentLikeList().stream().map(CommentLikeDto::toResponse).collect(Collectors.toList()))
                .build();
    }

    public static CommentDto toAdd(CommentRequest commentRequest) {
        return CommentDto.builder()
                .content(commentRequest.getContent())
                .build();
    }
}
