package com.likelion.thinker.dto;

import com.likelion.thinker.entity.*;
import com.likelion.thinker.request.MemberRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class MemberDto {
    private Long memberId;

    private String name;

    private String email;

    private List<PostLikeDto> postLikeDtoList;

    private List<CommentLikeDto> commentLikeDtoList;

    private List<PostDto> postDtoList;

    private List<CommentDto> commentDtoList;

    public static MemberDto toPostResponse(Member member) {
        return MemberDto.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }

    public static MemberDto toMemberResponse(Member member) {
        return MemberDto.builder()
                .name(member.getName())
                .memberId(member.getMemberId())
                .build();
    }

    public static MemberDto toAdd(MemberRequest memberRequest) {
        return MemberDto.builder()
                .name(memberRequest.getName())
                .email(memberRequest.getEmail())
                .build();
    }

    public static MemberDto toResponse(Member member) {
        return MemberDto.builder()
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .name(member.getName())
                .postDtoList(member.getPostList().stream().map(PostDto::toMemberResponse).collect(Collectors.toList()))
                .postLikeDtoList(member.getPostLikeList().stream().map(PostLikeDto::toMemberResponse).collect(Collectors.toList()))
                .commentDtoList(member.getCommentList().stream().map(CommentDto::toMemberResponse).collect(Collectors.toList()))
                .build();

    }
}
