package com.likelion.thinker.dto;

import com.likelion.thinker.entity.Post;
import com.likelion.thinker.request.PostRequest;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PostDto {
    private Long postId;

    private String title;

    private String content;

    private LocalDateTime date;

    private MemberDto memberDto;

    private List<PostLikeDto> postLikeDtoList;

    private List<CommentDto> commentDtoList;

    public static PostDto toAdd(PostRequest postRequest) {
        return PostDto.builder()
                .content(postRequest.getContent())
                .title(postRequest.getTitle())
                .build();
    }

    public static PostDto toResponse(Post post) {
        return PostDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .date(post.getDate())
                .memberDto(MemberDto.toPostResponse(post.getMember()))
                .postLikeDtoList(post.getPostLikeList().stream().map(PostLikeDto::toResponse).collect(Collectors.toList()))
                .commentDtoList(post.getCommentList().stream().map(CommentDto::toResponse).collect(Collectors.toList()))
                .build();
    }

    public static PostDto toMemberResponse(Post post) {
        return PostDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .date(post.getDate())
                .memberDto(MemberDto.toMemberResponse(post.getMember()))
                .build();
    }
}
