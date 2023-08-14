package com.likelion.thinker.dto.response.member;

import com.likelion.thinker.dto.*;
import com.likelion.thinker.dto.response.bookmark.BookMarkResponse;
import com.likelion.thinker.dto.response.comment.CommentByAllPostResponse;
import com.likelion.thinker.dto.response.post.PostByMemberResponse;
import com.likelion.thinker.dto.response.postLike.PostLikeByMemberResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class MemberResponse {
    private Long memberId;

    private String name;

    private String email;

    private List<PostByMemberResponse> postList;

    private List<PostLikeByMemberResponse> postLikeList;

    private List<CommentByAllPostResponse> commentList;

    private List<BookMarkResponse> bookMarkList;

    public static MemberResponse toResponse(MemberDto memberDto) {
        return MemberResponse.builder()
                .memberId(memberDto.getMemberId())
                .email(memberDto.getEmail())
                .name(memberDto.getName())
                .postList(memberDto.getPostDtoList().stream().map(PostByMemberResponse::toPostByMemberResponse).collect(Collectors.toList()))
                .postLikeList(memberDto.getPostLikeDtoList().stream().map(PostLikeByMemberResponse::toPostLikeByMemberResponse).collect(Collectors.toList()))
                .commentList(memberDto.getCommentDtoList().stream().map(CommentByAllPostResponse::toCommentResponse).collect(Collectors.toList()))
                .bookMarkList(memberDto.getBookMarkDtoList().stream().map(BookMarkResponse::toResponse).collect(Collectors.toList()))
                .build();
    }
}
