package com.likelion.thinker.response;

import com.likelion.thinker.dto.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MemberResponse {
    private Long memberId;

    private String name;

    private String email;

    private List<PostLikeDto> postLikeDtoList;

    private List<PostDto> postDtoList;

    private List<CommentDto> commentDtoList;

    public static MemberResponse toResponse(MemberDto memberDto) {
        return MemberResponse.builder()
                .memberId(memberDto.getMemberId())
                .email(memberDto.getEmail())
                .name(memberDto.getName())
                .postDtoList(memberDto.getPostDtoList())
                .postLikeDtoList(memberDto.getPostLikeDtoList())
                .commentDtoList(memberDto.getCommentDtoList())
                .build();
    }
}
