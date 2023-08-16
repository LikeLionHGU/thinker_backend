package com.likelion.thinker.dto.response.post;

import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.dto.response.comment.CommentByAllPostResponse;
import com.likelion.thinker.dto.response.comment.CommentByPostResponse;
import com.likelion.thinker.dto.response.member.MemberByPostResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class APostResponse {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime date;

    private MemberByPostResponse member;

    private Integer postLikeCount;

    private List<CommentByPostResponse> commentList;

    private Boolean isLiked;

    public static APostResponse toResponse(PostDto postDto) {
        return APostResponse.builder()
                .postId(postDto.getPostId())
                .member(MemberByPostResponse.toMemberByPostResponse(postDto.getMemberDto()))
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .date(postDto.getDate())
                .postLikeCount(postDto.getTotalPostLikeCount())
                .commentList(postDto.getCommentList().stream().map(CommentByPostResponse::toCommentByPostResponse).collect(Collectors.toList()))
                .isLiked(postDto.getIsLiked())
                .build();
    }
}
