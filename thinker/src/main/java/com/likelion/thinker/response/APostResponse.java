package com.likelion.thinker.response;

import com.likelion.thinker.dto.CommentDto;
import com.likelion.thinker.dto.MemberDto;
import com.likelion.thinker.dto.PostDto;
import com.likelion.thinker.dto.PostLikeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class APostResponse {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime date;

    private MemberDto memberDto;

    private List<PostLikeDto> postLikeDtoList;

    private List<CommentDto> commentDtoList;

    public static APostResponse toResponse(PostDto postDto) {
        return APostResponse.builder()
                .postId(postDto.getPostId())
                .memberDto(postDto.getMemberDto())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .date(postDto.getDate())
                .commentDtoList(postDto.getCommentDtoList())
                .postLikeDtoList(postDto.getPostLikeDtoList())
                .build();
    }
}
